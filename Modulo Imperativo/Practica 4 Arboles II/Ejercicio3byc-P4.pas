program ejercicio3byc;
// no es una lista, ya que no dice EXPLICITAMENTE que los productos deben quedar guardados en una LISTA.
type 
venta = record
codVenta:integer;
codProd:integer;
uVendidas:integer;
precio:real;
end;

producto = record
cod:integer; // No hace falta volver a agregarlo porque el árbol ya esta ord por codProd, está mal repetir.
uVendidas:integer;
montoTotal:real;
end;

arbol = ^nodoArbol;

nodoArbol = record
codProd:integer; // Criterio = cod producto
dato:producto; 
hI:arbol;
hD:arbol;
end;


procedure actualizarMax(codProd,uVendidas:integer; var maxVendidas,cod:integer);
begin
// Si las uVendidas del producto actual son > que maxVendidas
 if(uVendidas > maxVendidas)then
 begin
   maxVendidas := uVendidas;
   cod := codProd; // Me guardo el cod con > cantidad de u. vendidas.
 end;
end;

// Punto c.
// Tenemos que retornar un cod de producto, pero buscando el que tenga más ventas. Como el criterio es el codProd , en este caso
// debemos recorrer todo el árbol buscando > venta.
procedure maximo(a:arbol; var maxVendidas,cod:integer);
begin
 if(a <> nil)then
 begin
   actualizarMax(a^.codProd, a^.dato.uVendidas,maxVendidas,cod);
   maximo(a^.hI, maxVendidas, cod);
   maximo(a^.hD,maxVendidas,cod);
 end; 
end;

// Punto b.
procedure imprimirEnOrden(a:arbol);
begin
  if(a <> nil)then
  begin
   imprimirEnOrden(a^.hI);
   writeln(a^.codProd);
   writeln(a^.dato.uVendidas);
   writeln(a^.dato.montoTotal);
   imprimirEnOrden(a^.hD);
  end;
end;
 
 
 
 
  
 procedure agregarAlArbol(var a:arbol; v:venta);
  begin 
   if(a = nil)then
   begin
    new(a); 
    a^.codProd := v.codProd; // IMPORTANTE, debe estar 1 sola vez
    a^.dato.uVendidas := v.uVendidas;
    a^.dato.montoTotal := v.precio;
    a^.hI :=nil;
    a^.hD:= nil;
   end
   else 
    if (v.codProd > a^.codProd)then 
    begin
     agregarAlArbol(a^.hD,v); 
    end
    else 
     if (v.codProd < a^.codProd)then 
     begin
        agregarAlArbol(a^.hI,v); 
     end
     else 
     begin
     // La venta ya se encuentra en el registro:
      a^.dato.uVendidas := a^.dato.uVendidas + v.uVendidas;
      a^.dato.montoTotal := a^.dato.montoTotal + (v.uVendidas * v.precio);
      end;
  end;
 
procedure leerVentas(var v: venta);
begin
  write('Cod venta: '); read(v.codVenta);
  if v.codVenta <> -1 then
  begin
    write('Cod producto: '); read(v.codProd);
    write('Unidades vendidas: '); read(v.uVendidas);
    write('Precio unitario: '); read(v.precio);
  end;
end;


procedure cargarVentas(var a:arbol);
var 
 v:venta;
begin 
leerVentas(v);
 while(v.codVenta <>  -1)do
 begin
  agregarAlArbol(a,v);
  leerVentas(v); 
 end;
end;

var
a:arbol;
maxVendidas,cod:integer;
begin 
a:= nil;
maxVendidas := -999;
cod:= 0;
cargarVentas(a);
imprimirEnOrden(a);
maximo(a,maxVendidas,cod);
end.
