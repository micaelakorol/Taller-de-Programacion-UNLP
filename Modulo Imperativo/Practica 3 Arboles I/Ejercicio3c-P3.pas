program ejercicio3c;

type
lista = ^nodo; 
arbol = ^nodoArbol;

/////////////////////////////////////////////////////
listaProm = ^nodoProm;

datoProm = record
promedio:real;
legajo:integer;
end;

nodoProm = record
dato:datoProm;
sig:listaProm;
end;
/////////////////////////////////////////////////////
fecha = record
dia:integer;
mes:integer;
anio:integer;
end;


alumno = record
legajo:integer;
codMateria:integer;
fechaAlu:fecha;
nota:real;
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


//procedure agregarListaProm(var l:listaProm; prom:real; nroLegajo:integer);

function promedio(l:lista):real;
var 
  contarNotas:integer;
  suma:real;
begin 
 suma := 0; contarNotas:=0;
 while(l <> nil)do
 begin 
   suma := suma + l^.dato.nota; // acumulo las notas
   contarNotas := contarNotas  + 1;
   l := l^.sig; 
 end;
  promedio := suma / contarNotas;
end;

procedure retornarLegajos(valor:real; a:arbol; var l:listaProm);
var 
 prom:real;
begin 
 // Tengo que recorrer todo el árbol ,  y de cada lista de alumnos, sacar el promedio de sus notas.
  if(a  <> nil)then 
  begin 
   prom :=  promedio(a^.dato); // Le paso la lista
   if(prom >= valor )then 
   begin
    //agregarListaProm(l,prom,a^.nroLegajo); ---------------> Agregar y despues retornar la nueva lista?
    write('Promedio:' , prom); // Debo insertar el promedio y legajo en una nueva lista y desp recorrerla?
    write('Legajo: ', a^.nroLegajo);
   end;
   retornarLegajos(valor, a^.hI, l);
   retornarLegajos(valor, a^.hD, l);
  end;
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
  write('Legajo:');
  read(alu.legajo);
 if(alu.legajo <> 0)then // Si no pongo esta comprobación, me deja ingresar el legajo 0
 begin
  write('Nota:');
  read(alu.nota); 
  write('Cod materia:');
  read(alu.CodMateria); 
  write('Dia:');
  read(alu.fechaAlu.dia);  // registro anidado
  write('Mes:');
  read(alu.fechaAlu.mes);
  write('Año:');
  read(alu.fechaAlu.anio);
 end;

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
l:listaProm; ///////////////////////////
a:arbol;
valor:real;
begin 
l:=nil; ///////////////////////////
valor :=  4.0;
a:=nil; // pongo el árbol en nil.
cargarAlumnos(a);
retornarLegajos(valor,a,l); /////////////////////////////
end.
