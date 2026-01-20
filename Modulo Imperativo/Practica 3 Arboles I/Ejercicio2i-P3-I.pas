program ejercicio2i;
// Pasar la fecha como un registro anidado.
type

ventas = record
codProducto:integer;
fecha:integer;
uVendidas:integer;
end;

arbol = ^nodo;

nodo = record
dato:ventas;
hD:arbol;
hI:arbol
end;

// Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad  total de productos vendidos en la fecha recibida. 
// Como el arbol no esta ordenado por fecha, debo recorrerlo todo.
// Ver el funcionamiento interno de esta funcion.
function recorrerArbol(a:arbol; fecha:integer):integer;
begin
 if(a = nil)then
 begin
  recorrerArbol := 0; 
 end;
 else 
//Suma uVendidas del nodo actual
//Llama recursivamente a los subárboles izquierdo y derecho y suma sus resultados
  if(a^.dato.fecha = fecha)then
  begin
   recorrerArbol := a^.dato.uVendidas + recorrerArbol(a^.hI,fecha) + recorrerArbol(a^.hD,fecha);
  end;
  else 
   recorrerArbol := recorrerArbol(a^.hI,fecha)
  + recorrerArbol(a^.hD,fecha);
end;

procedure agregarAlArbol(var a: arbol; v: ventas);
begin
  if a = nil then
  begin
    new(a);
    a^.dato := v;
    a^.hI := nil;
    a^.hD := nil;
  end
  else if v.codProducto < a^.dato.codProducto then
    agregarAlArbol(a^.hI, v)  // menor izquierda
  else
    agregarAlArbol(a^.hD, v); // si el cod es mayor o igual, va a la derecha.
end;

procedure leerVentas(var a:arbol);
var 
 v:ventas;
begin
 read(v.codProducto);
 while(v.codProducto <> 0)do
 begin
  read(v.fecha);
  read(v.uVendidas);
  agregarAlArbol(a,v);
  read(v.codProducto); 
 end;
end;

var
a:arbol;
fecha,cont:integer;
begin
a:=nil;
cont := 0;
fecha:= 10;
leerVentas(a);
recorrerArbol(a,fecha,cont);
writeln('En la fecha ', fecha, ' se vendieron ', total, ' unidades');
end.
