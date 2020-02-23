-- simple queries
select * from Kunde;
select * from Ordre;
select * from vare;

-- cartesian product og join
select * from Kunde, Ordre;

select K.Navn, O.Ordredato, O.VareNr
  from Kunde K, Ordre O 
  where K.KundeId = O.KundeId;

-- join med qualifications og projection
select * 
  from Kunde K, Ordre O 
  where K.KundeId = O.KundeId
  and O.OrdreDato = '2009-02-02';
select K.KundeId, K.Navn, O.VareNr, O.Antal 
  from Kunde K, Ordre O 
  where K.KundeId = O.KundeId
  and O.OrdreDato = '2009-02-02'; 

  -- order by
select K.KundeId, K.Navn, O.VareNr, O.Antal 
  from Kunde K, Ordre O 
  where K.KundeId = O.KundeId
  and O.OrdreDato = '2009-02-02'
  order by VareNr asc;

-- join over flere tabeller
select K.KundeId, K.Navn, O.VareNr, V.Emne, O.Antal 
  from Kunde K, Ordre O, Vare V 
  where K.KundeId = O.KundeId
  and O.OrdreDato = '2009-02-02'
  and O.VareNr = V.VareNr;

select K.KundeId, K.Navn, P.Bynavn, O.VareNr, V.Emne, O.Antal 
  from Kunde K, Ordre O, Vare V, PostDistrikt P 
  where K.KundeId = O.KundeId
  and K.PostNr = P.PostNr
  and O.OrdreDato = '2009-02-02'
  and O.VareNr = V.VareNr;
  
-- left join, right join og full join  
select * from Kunde K 
  left join Ordre O
  on O.KundeId = K.KundeId;

select * from Kunde K 
  right join Ordre O
  on K.KundeId = O.KundeId;  

-- Vise Ordre og Varer - også Varer der IKKE er i ordre
select * from Ordre O 
  left join Vare V
  on O.VareNr = V.VareNr;  
  
select * from Kunde K 
  full join Ordre O
  on O.KundeId = K.KundeId;
  
select * from Kunde K 
  inner join Ordre O
  on O.KundeId = K.KundeId;  
  
-- nested query or Sub Quries
select * 
  from Vare V
  where V.VareNr in ( select O.VareNr
                        from Ordre O );    
select * 
  from Vare V
  where V.VareNr not in ( select O.VareNr
                            from Ordre O );  

select * from Kunde
	where navn like '__n%'; 
select * from Kunde
	where adresse like '%vej%'; 
