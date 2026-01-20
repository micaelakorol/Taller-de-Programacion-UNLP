program ejercicio3a;

type
lista = ^nodo; 
arbol = ^nodoArbol;

fecha = record
dia:integer;
mes:integer;
anio:integer;
end;


alumno = record
legajo:integer;
codMateria:integer;
fechaAlu:fecha;
nota:integer;
end;

nodo = record
dato:alumno;
sig:lista;
end;

nodoArbol = record
nroLegajo:integer; {criterio del árbol}
dato:lista;
hD:arbol;
hI:arbol;
end;

procedure agregarALaLista(var l:lista; alu:alumno); 
var 
 nuevo:lista;
begin 
 new(nuevo); 
 nuevo^.dato := alu;
 nuevo^.sig := nil;
 if(l = nil)then 
 begin
  l := nuevo; 
 end
 else
 begin
  nuevo^.sig := l;
  l := nuevo;
 end;
end;

procedure agregarAlArbol(var a:arbol; alu:alumno);
begin
 if (a = nil)then 
 begin
 //a^.dato[nroLegajo] := dato; -> en caso de que sea un arbol de vector
  new(a); // pido espacio para el nodo del árbol
  a^.nroLegajo := alu.legajo;  // Le cargo el criterio al primer nodo.
  a^.dato := nil; // Pongo la lista en nil.
  a^.hI := nil;
  a^.hD := nil;
  agregarALaLista(a^.dato, alu); // a^.dato = lista;
 end
 // Siempre comparamos con el criterio de ordenación del árbol.
 else 
  if(alu.legajo < a^.nroLegajo)then
  begin
   agregarAlArbol(a^.hI, alu)  // voy al hijo izquierdo 
  end
  else 
   if(alu.legajo > a^.nroLegajo)then
   begin
     agregarAlArbol(a^.hD, alu)  // voy al hijo derecho a ver si puedo agregar  
   end
     else
     begin
      agregarALaLista(a^.dato, alu); // el legajo ya existe lo agrego a la lista
     end;
end;

procedure leerAlumno(var alu:alumno);
begin
 read(alu.legajo);
 read(alu.nota); 
 read(alu.CodMateria); 
 read(alu.fechaAlu.dia);  // registro anidado
 read(alu.fechaAlu.mes);
 read(alu.fechaAlu.anio);
end;

procedure cargarAlumnos(var a: arbol);
var 
  alu: alumno;
begin
  leerAlumno(alu); // 1° lectura
  while (alu.legajo <> 0) do 
  begin
    agregarAlArbol(a, alu);
    leerAlumno(alu); // vuelvo a leer
  end; 
end;

var
a:arbol;
begin 
a:=nil; // pongo el árbol en nil.
cargarAlumnos(a);
end.
