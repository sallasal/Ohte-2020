# Pilkkuharjoittelusovelluksen testausdokumentti

Ohjelman toiminnallisuutta on testattu JUnit-kirjaston yksikkö- ja integraatiotesteillä.
Järjestelmätason toiminnallisuudet on testattu manuaalisesti kaikissa kehityksen vaiheissa.

## Integraatio- ja yksikkötestaus

### JUnit: integraatiotestaus

Integraatiotestauksessa keskeistä oon testata CommaService-luokan toiminta mahdollisimman tarkasti. Tämä on toteutettu testiluokissa *CommaServiceExerciseTest*, *CommaServiceUserTest*.
Nimiensä mukaisesti luokat testaavat (vastaavasti) käyttäjään liittyviä, harjoituksiin liittyviä ja palkintoihin liittyviä CommaServicen metodeja.
Palkintoihin liittyvät CommaServicen metodit on nostettu omaksi luokakseen, sillä ne hyödyntävät sekä harjoitusten että käyttäjän tietoja ja ovat selvästi oma kokonaisuutensa ohjelman toiminnassa.

### JUnit: yksikkötestaus

Yksittäisiä yksikkötestejä on lisätty niille luokille, joiden testikattavuus ja yksittäisten toiminnallisuuksien testaus jäi integraatiotestauksen jälkeen vielä vajaaksi. 

Testejä lisättiin tästä syystä yllä mainittuihin testiluokkiin, mutta myös luokkiin *ExerciseDaoDbTest* sekä *ExerciseTest*.

### JUnit ja tiedon tallennus

Sekä integraatio- että yksikkötestauksessa testataan metodeja, jotka joko lukevat tietokannasta dataa tai kirjoittavat tietokantaan.
Testejä varten määritetään uusi tietokanta joko CommaServiceä luotaessa (integraatiotestauksessa) tai ExerciseDaoDb:tä luotaessa (yksikkötestaus).
Tietokanta sijoitetaan ohjelman /Pilkkuharjoittelu-juureen, kuten varsinainen tietokantakin, ja se on nimeltään *CommasTest.db*.

Tiedoston luku testataan yksikkötestauksessa luokassa *ExerciseDaoDbTest*. Metodi *initializationAndExerciseBringingWorks* lukee samaa resource-tiedostoa *exercises.csv* kuin itse ohjelma.
Tähän tiedostoon ei ohjelmassa kirjoiteta mitään.

### Integraatio- ja yksikkötestauksen testikattavuus

Testikattavuuskuva on otettu 18.12.2020 klo 16:15, minkä jälkeen muutoksia testikoodiin tai itse ohjelmakoodiin ei ole tehty.

<img src="https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/testikattavuus_20201218.png">

Tällä hetkellä yksikkötestausten piiristä puuttuvat lähinnä tilanteet, joihin ei pitäisi koskaan joutua (esim. integraatiotestauksen kautta) - virheellisten arvojen palautusarvot ja muutamia virheellisen syötteen validointihaaroista.

## Järjestelmätestaus

Järjestelmätestausta on totetutettu manuaalisesti koko kehitystyön ajan. Sovelluksesta on testattu kaikki toiminnot kehitysvaiheessa sekä toimintojen yhteen toiminen jälkikäteen.

Käyttäjän kaikki mahdolliset toiminnot, siis erilaiset klikkaukset ja syötteet, on testattu. Käyttäjän syötteet validoidaan ohjelmassa (toteutus CommaServicessä), ja validoinnin oikeellisuus on testattu erilaisilla syötteillä.

Ohjelman toimivuus on testattu useammalla tietokoneella. Myös ajautuminen Java-komennoilla, NetBeansin kautta ja .jar-tiedostona on testattu omalla koneella ja yliopiston virtuaaliympäristössä.

Kattavassa järjestelmätestauksessa ei saatu rakennettua tilanteita, joissa ohjelma heittäisi konsoliin errorin. Kaikki virheet printtaavat konsoliin virheviestin (logituksen sijaan), joten mahdollisten errorien tulisi kyllä näkyä konsolissa kaikissa tilanteissa. Myöskään ohjelman kaatumista ei saatu rakennettua testauksessa tavanomaisesta virhekäytöstä huolimatta.

Monimutkaisempaan toteutukseen olisi kyllä kannattanut toteuttaa logitus, joka parantaisi ohjelman ylläpidettävyyttä.
