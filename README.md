# Ristinolla

Ristinolla on peli jossa pelataan vastakkain. Kyseisessä variaatiossa voidaan luoda pelialusta mielivaltaisella koolla. On kuitenkin pieniä rajoituksia. koko maksimissaan 100 ja minimissään 3 ruutua.

## Ominaisuudet
Pelilaudan kokoa voi nyt säätää. Pelaajien vuorot indikoidaan ja kerrotaan kumpi on voittaa. Pitää lisätä testejä ja korjata testien toimivuus.

## Dokumentaatio
[Työaikakirjanpito](https://github.com/msiivone/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  
[Vaatimusmäärittely](https://github.com/msiivone/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

##  14.12
- Testit rikkoivat ohjelman toiminnan. Ohjelmaa pystyy ajamaan ilman testejä mutta ei testien kanssa.

# Komentorivi
- Ohjelma voidaan käynnistää komennolla   
mvn compile exec:java -Dexec.mainClass=ristinolla.Main
