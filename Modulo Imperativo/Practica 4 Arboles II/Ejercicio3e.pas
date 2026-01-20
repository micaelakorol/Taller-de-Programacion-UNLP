program ejercicio3e;
// no es una lista, ya que no dice EXPLICITAMENTE que los productos deben quedar guardados en una LISTA.
type 
venta = record
codVenta:integer;
codProd:integer;
uVendidas:integer;
precio:real;
end;

producto = record
cod:integer;
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
 

// ¿Que me pide? Acumular los montos de los cod de prod que esten en un rango. 
// ¿Por cual criterio esta ordenado? cod. Entonces uso total.
// Si me hubiera pedido buscar montos totales mayores que v1 , ahi si seria total
function acumularMontos(v1, v2: integer; a: arbol): real;
begin
    if a = nil then
        acumularMontos := 0
    else if (a^.codProd > v1) and (a^.codProd < v2) then // esta en rango?
        acumularMontos := a^.dato.montoTotal
                         + acumularMontos(v1, v2, a^.hI)
                         + acumularMontos(v1, v2, a^.hD)
    else if a^.codProd >= v2 then
        acumularMontos := acumularMontos(v1, v2, a^.hI)  //Solo recorre el subárbol que puede contener nodos válidos:
    else // a^.codProd <= v1
        acumularMontos := acumularMontos(v1, v2, a^.hD); // solo derecha
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
begin 
a:= nil;
cargarVentas(a);
end.
