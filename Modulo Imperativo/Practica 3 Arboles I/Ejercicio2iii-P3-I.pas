program ejercicio2iii;
type


producto = record
cod:integer;
fecha:integer;
uVendidas:integer;
end;

lista = ^nodo;

nodo = record
dato:producto;
sig:lista;
end;

arbol = ^nodoArbol;

nodoArbol = record
cod:integer; {--- criterio de ordenación del árbol}
venta:lista; {-----------------------}
hI:arbol;
hD:arbol;
end;

// Esta funcion debe acumular todas las ventas de la lista:

function totalVentasLista(l:lista):integer; 
var
 totalVentas:integer;
begin
 totalVentas := 0;
 while(l <> nil) do
 begin
   totalVentas := totalVentas + l^.dato.uVendidas;
   l := l^.sig; // AVANZAR EN LA LISTA.
 end; 
  totalVentasLista := totalVentas;
end;

// Recorrer la lista de cada codProducto e ir acumulandolas.
// Recorrer c/ lista y acumular el total de ventas de cada una , hallar la que más vendió y retornar su cod.
procedure recorrerArbolMax(a:arbol; var ventasMax:integer; var codMax:integer);
var 
 total:integer;
begin
 if(a <> nil)then 
 begin
  total := totalVentasLista(a^.venta); // envio la lista para recorrerla y acumular las u. vendidas.
  if (total > ventasMax)then
  begin
   ventasMax := total;
   codMax := a^.cod; // me guardo el cod de la lista con > ventas.
  end;
 // Recorrer subárboles izquierdo y derecho
  recorrerArbolMax(a^.hI, ventasMax, codMax);
  recorrerArbolMax(a^.hD, ventasMax, codMax);
 end; 
end;


procedure agregarAlaLista(var l: lista; p: producto);
var
  nuevo: lista;
begin
  new(nuevo);
  nuevo^.dato := p;
  nuevo^.sig := nil;

  if l = nil then
    l := nuevo
  else
  begin
    nuevo^.sig := l;
    l := nuevo;
  end;
end;


procedure agregarAlArbol(var a:arbol; p:producto);
begin
if (a = nil)then
begin
 new(a);
 a^.cod := p.cod; {---- Agrega por el criterio}
 a^.hI := nil;
 a^.hD := nil;
 a^.venta := nil; {pongo la lista en nil}
 agregarAlaLista(a^.venta, p);  {-- Agrega a la lista}
end
 else 
  if(p.cod < a^.cod)then
  begin
   agregarAlArbol(a^.hI, p); 
  end
  else 
   if(p.cod > a^.cod)then
   begin
     agregarAlArbol(a^.hD, p); 
   end
   else 
   // Quiee decir que el codigo ya existe en la lista , solo debo acumular las cant Vendidas.
    agregarAlaLista(a^.venta, p);
end;
// a^.venta es la LISTA 
// agregarAlArbol(a^.hD, p); esas partes no crean nodos nuevos directamente, sino que recorren el árbol hasta encontrar dónde insertar o dónde acumular datos.


{Leemos y agregamos las ventas a la lista: --- Agregamos a la lista como siempre:}
 procedure leerVentas(var a:arbol);
 var
  p:producto;
  begin 
   read(p.cod);
   while(p.cod <> 0)do 
   begin
    read(p.fecha);
    read(p.uVendidas);
    agregarAlArbol(a,p);
    read(p.cod); 
   end;
  end;
var 
ventasMax, codMax:integer;
a:arbol;
begin
a := nil;
ventasMax := -999;
codMax := 0;
leerVentas(a); 
recorrerArbolMax(a,ventasMax,codMax);
end.
