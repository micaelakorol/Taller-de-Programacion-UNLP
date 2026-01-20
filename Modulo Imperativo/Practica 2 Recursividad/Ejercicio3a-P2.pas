program ejercicio3a;

const 
dimL  = 20;
type
vector = array [1..20] of integer;

procedure cargarVectorRecursivo(var v:vector;i:integer);
var 
 num:integer; 
 begin
  num := Random(1550-300+1) + 300; 
  if(i <= dimL)then // Si esto se cumple, se corta la recursión
  begin
   v[i] := num;
   cargarVectorRecursivo(v,i+1);
  end;
 end;



var
v:vector;
i:integer;
begin
i:= 1;
//inicializar sus posiciones a 0.
Randomize;
cargarVectorRecursivo(v,i);
end.
