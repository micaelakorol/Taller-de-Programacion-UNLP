program ejercicio2ii;


// Arreglar el campo fecha, debe ser un registro anidado. 
// Si lo que debo buscar no es por el criterio de ordenamiento del arbol, debo recorrerlo TODO. Correcto y consultado

type

producto = record
cod:integer;
fecha:integer;
uVendidas:integer;
end;

venta = record
cod:integer;
uVendidas:integer;
end;

arbol = ^nodo;
nodo = record
dato:venta;
hD:arbol;
hI:arbol
end;


// Si tuviera que hallar el maximo código:
// 3 casos: Que el árbol sea nil, que hD sea nil o que siga recorriendo hasta llegar al caso 2 a^.hD = nil
function hallarMaxCodigo(a:arbol):integer;
begin
 if(a=nil)then
 begin
  hallarMaxCodigo := 0; 
 end
 else 
 // Si no hay hijo derecho, este nodo es el máximo.
  if(a^.hD  = nil)then 
  begin 
    hallarMaxCodigo := a^.dato.cod;
  end
  else 
  // Todavía puede haber códigos mayores a la derecha.
   hallarMaxCodigo := hallarMaxCodigo(a^.hD);  // sigo a la derecha
end;




// Correcto y consultado.
procedure actualizarMax(cod,uVendidas:integer; var maxCod:integer; var maxUVendidas:integer);
begin
 if (uVendidas > maxUVendidas)then 
 begin
  maxCod := cod;
  maxUVendidas := uVendidas 
 end;
end;

// retorne el código de producto con mayor cantidad total de unidades vendidas. 
// Como en el arbol estan agrupados por cod producto y tenemos las unidades vendidas, solo buscamos el mayor.
// Debemos recorrer todo el arbol , ya que no esta ordenado por u. vendidas. (Correcto y consultado)
procedure hallarMax(a:arbol; var maxCod:integer; var maxUVendidas:integer);
begin
  if(a <> nil)then 
  begin
   actualizarMax(a^.dato.cod, a^.dato.uVendidas, maxCod, maxUVendidas);
   hallarMax(a^.hI, maxCod, maxUVendidas);
   hallarMax(a^.hD, maxCod, maxUVendidas);
  end;
end;

// Acá debo hallar el maximo codigo, y como el árbol esta ordenado por código puedo usar la búsqueda mejorada:



procedure agregarAlArbol(var a:arbol; p:producto);
 begin
  if(a = nil)then 
  begin
   new(a);
   a^.dato.cod := p.cod;
   a^.dato.uVendidas := p.uVendidas;
   a^.hI := nil;
   a^.hD := nil;
  end
  else 
   if(p.cod < a^.dato.cod)then
   begin
    agregarAlArbol(a^.hI,p); 
   end
   else 
    if (p.cod > a^.dato.cod)then
    begin
     agregarAlArbol(a^.hD,p);  
    end
    // Si no, los codigos son iguales:
    else 
      a^.dato.uVendidas :=  a^.dato.uVendidas + p.uVendidas;
 end;


procedure leerProductos(var a:arbol);
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
a:arbol;
maxCod, maxUVendidas:integer;
begin 
maxCod := -999;
maxUVendidas := 0;
a:= nil;
leerProductos(a);
hallarMax(a,maxCod,maxUVendidas);
write('El codigo con mas unidades vendidas es: ', maxCod, 'con', maxUVendidas , 'unidades vendidas totales');
hallarMaxCodigo(a); // Módulo de práctica con búsqueda mejorada por criterio de ordenación.
end.
