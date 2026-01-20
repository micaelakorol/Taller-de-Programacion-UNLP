program ejercicio3d;
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

function menoresQueValor(a:arbol;valor:integer):integer;
begin
 // Como tenemos una funcion , siempre el primer caso será a = nil para que retorne 0.
 // Si el árbol esta vacío, no hay nada que contar.
 if(a = nil)then 
 begin
  menoresQueValor := 0; 
 end;
 else 
 // Si el nodo cumple que es menor al valor, recorremos todos los hijos:
  if(a^.codProd < valor)then 
  // En esta comparación, recorremos ambos lados del nodo pq pueden cumplir la condición
  begin
   menoresQueValor := menoresQueValor(a^.hI) + menoresQueValor(a^.hD) + 1;  
  end;
  else 
    menoresQueValor := menoresQueValor(a^.hI, valor);
end;
 ///// pregunto
 
 
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
valor:integer;
begin 
valor := 77;
a:= nil;
cargarVentas(a);
end.
