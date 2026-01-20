program ejercicio4i

prestamo = record
nroSocio:integer;
dia:1..31;
mes:1..12;
diasPrestados:integer;
end;

arbol = ^nodoArbol; 

ISBN:integer; // El criterio del árbol va acá no en el registro 'prestamo' pq sino se repite.
dato:prestamo;
hI:arbol;
hD:arbol;
end;

// f. ------- Si se que los repetidos van a la derecha, aunque tenga que recorrer todo el árbol, hay alguna forma de aprovechar eso ? si uso cualquiera de los recorridos está bien ?

// d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El 
// módulo debe retornar la cantidad de préstamos realizados a dicho socio. 

function contarPrestamos(a:arbol; nroSocio:integer):integer;
begin  
 // a = nil; a = nroSocio o  
 // else hD , hI porque no estamos buscando por el criterio.
 if(a = nil)then 
 begin
  contarPrestamos := 0; 
 end;
  else 
   if (nroSocio = a^.dato.nroSocio)then
   begin
   contarPrestamos := contarPrestamos(a^.hD,nroSocio) + contarPrestamos(a^.hI,nroSocio) + 1;
   end
   //Todos los préstamos del subárbol izquierdo
  //Todos los préstamos del subárbol derecho
  //+1 si el nodo actual coincide con el socio
   else 
   contarPrestamos := contarPrestamos(a^.hI, nroSocio) + contarPrestamos(a^.hD, nroSocio);
end; 



// b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más grande.  
// Como el árbol está ordenado por ISBN , recorremos solo el subarbol derecho.
// La función no recorre el izquierdo ni todos los nodos, porque el mayor siempre estará en la rama derecha de un BST ordenado por ISBN.
 function retornarMayorISBN(a:arbol):integer;
 begin
  if(a^.hD = nil)then
  begin
   retornarMayorISBN := a^.ISBN; 
  end 
  else
   retornarMayorISBN := retornarMayorISBN(a^.hD);
 end;

procedure leerPrestamo(var p:prestamo; var isbn:integer);
 begin 
  readln(isbn);
  if(isbn <> 0)then
  begin
    readln(p.nroSocio);
    readln(p.dia);
    readln(p.mes);
    readln(p.diasPrestados);
  end;
 end;
 
 
 procedure agregarAlArbol(var a:arbol; p:prestamo; isbn:integer);
 begin
  // Si a = nil ; creo el nodo desde cero.
  // Si no, si isbn < , al hI
  // Si no, significa que, el isbn es > o repetido. ¿Agrego el nodo entero nuevamente?-----------
  if (a = nil)then // Este paso se hace solo 1 vez.
  begin
   new(a);
   a^.isbn := isbn; // IMPORTANTE, le cargo el ISBN de la VARIABLE para no repetir el campo y volver a agregarlo.
   a^.dato.nroSocio := p.nroSocio;
   a^.dato.dia := p.dia;
   a^.dato.mes := p.mes;
   a^.dato.diasPrestados := p.diasPrestados;
   a^.hI := nil;
   a^.hD := nil; 
  end;
  else 
   if (isbn < a^.ISBN)then
   begin
    agregarAlArbol(a^.hI, p, isbn);
   end;
   // Quiere decir que isbn > o repetido; insertar en subárbol derecho (repetidos a la derecha)
   else 
    agregarAlArbol(a^.hD, p , isbn);
 end;

// i. En una estructura cada préstamo debe estar en un nodo. Los ISBN repetidos insertarlos a la derecha. 
procedure cargarPrestamos(var a:arbol);
var 
 p:prestamo;
 isbn:integer; // Creo una variable para leer el isbn; ¿Está bien esto?
 begin
  leerPrestamo(p,isbn); 
  while(isbn <> 0)do 
  begin
   agregarAlArbol(a,p,isbn);
   leerPrestamo(p,isbn); 
  end;
 end;


var
a:arbol;
begin 
a:=nil;
cargarPrestamos(a);
retornarMayorISBN(a);
end.
