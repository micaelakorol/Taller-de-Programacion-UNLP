program ejercicio4;
type
// seguir con el punto c. ejercicio4.
lista = ^nodoLista;

nodoLista = record
dato:prestamos;
sig:lista;
end;

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
datoArbol:lista; // LISTA
hI:arbol;
hD:arbol;
end;

// Hacemos busqueda mejorada, pq estamos buscando por criterio.
function mayorISBN(a:arbol):integer;
begin 
  if (a = nil)then
  begin 
    mayorISBN := -1; // el arbol esta vacío
  end
  else if (a^.hD = nil) then 
  begin
    mayorISBN := a^.ISBN  
  // porque ya NO puedo bajar más a la derecha, no hay >
  end
   else 
     mayorISBN := mayorISBN(a^.hD);  // sigo bajando por derecha
end;

//procedure leerPrestamos(var p:prestamos);
// Recibo a^.datoArbol como una lista.
procedure agregarALista(var l: lista; p: prestamo);
var 
  nuevoNodo:lista;
  begin 
    new(nuevo); // pido espacio para el nuevo nodo
    nuevo^.dato.nroSocio := p.nroSocio;
    nuevo^.dato.dia := p.dia;
    nuevo^.dato.mes := p.mes;
    nuevo^.dato.diasPrestados := p.diasPrestados;
    nuevo^.sig := l;
    l := nuevo;
  end;
  // Cada nodo debe contener todos los prestamos de igual isbn.

procedure agregarAlArbol(p:prestamo; var a:arbol)
begin
  if( a = nil)then
  begin
   new(a);
   a^.isbn := p.isbn;
   a^.datoArbol := nil; // pongo la lista en nil.
   // tbm puedo hacer un agregarALaLista:
   agregarALista(a^.datoArbol, p); // primer préstamo en la lista
   // a^.datoArbol es la lista. Acá comienza vacía.
   a^.hI := nil;
   a^.hD := nil;
  end
  else 
    if (p.isbn < a^.isbn)then // comparo lo que leo con el criterio.
    begin 
      agregarAlArbol(p,a^.hI);
    end
    else
      if (p.isbn > a^.isbn)
      begin
        agregarAlArbol(p,a^.hD);
      end;      
      else 
       begin
         // MISMO ISBN → agrego a la lista del nodo
         agregarALista(a^.datoArbol, p);
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
mayorISBN(a);
end.