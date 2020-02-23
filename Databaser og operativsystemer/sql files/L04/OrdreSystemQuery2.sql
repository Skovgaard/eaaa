
-- nested query
select * 
  from Vare V
  where V.VareNr in ( select O.VareNr
                        from Ordre O );    
select * 
  from Vare V
  where V.VareNr not in ( select O.VareNr
                            from Ordre O );

-- aggregeringer
select count(*) 
  from Vare V
  where V.VareNr in ( select O.VareNr
                        from Ordre O );

select max(LagerAntal)
  from Vare V;

select Va.VareNr 
  from Vare Va
  where Va.LagerAntal = ( select max(V.lagerAntal) 
                             from Vare V ); 
  
-- group by
select O.OrdreDato, max(O.Antal)
  from Ordre O
  group by O.OrdreDato; 
-- group by MED alias
select O.OrdreDato, max(O.Antal) as MaxAntal
  from Ordre O
  group by O.OrdreDato;

select * from Kunde;
select * from Vare;
select * from Ordre;
select * from PostDistrikt;
