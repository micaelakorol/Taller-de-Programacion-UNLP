program ejercicio4;
//Estructura 1: un prestamo en c/ nodo y repetidos a la derecha.
type

prestamo = record // REGISTRO SOLO PARA LECTURA
ISBN:integer;
nroSocio:integer;
dia:1..31;
mes:1..12;
diasPrestados:integer;
end;

prestamos = record // REGISTRO PARA EL TIPO DE ARBOL SIN ISBN
nroSocio:integer;
dia:integer;
mes:1..12;
diasPrestados:integer;
end;

arbol = ^nodo;

nodo = record
ISBN:integer; // CRITERIO = eficientes para buscar por ISBN.
dato:prestamos
hI:arbol;
hD:arbol;
end;

//procedure leerPrestamos(var p:prestamos);

procedure agregarAlArbol(p:prestamo; var a:arbol)
begin
  if( a = nil)then
  begin
   new(a);
   a^.isbn := p.isbn;
   a^.dato.nroSocio := p.nroSocio;
   a^.dato.dia := p.dia;
   a^.dato.mes := p.mes;
   a^.dato.diasPrestados := p.diasPrestados;
   a^.hI := nil;
   a^.hD := nil;
  end
  else 
    if (p.isbn < a^.isbn)then // comparo lo que leo con el criterio.
    begin 
      agregarAlArbol(p,a^.hI);
    end
    else
      begin
        agregarAlArbol(p,a^.hD); // si es > o = van a la derecha, en cada nodo, no hace falta acumular.
      end;      
end;

procedure cargarPrestamos(a);
var 
  p:prestamo; // usamos el registro de lectura
begin 
  leerPrestamos(p);
  while(p.isbn <> 0)do 
  begin 
    agregarAlArbol(p,a);
    leerPrestamos(p);
  end;
end;


var 
a:arbol;
begin 
a := nil; // comienza vacío
cargarPrestamos(a);
end.