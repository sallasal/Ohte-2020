# Sovelluksen arkkitehtuuri

## Rakenne

Ohjelma rakentuu kolmesta luokkapakkauksesta. Pakkaus *comma.ui* vastaa käyttöliittymätoiminnallisuuksista, *comma.domain* sovelluslogiikasta ja *comma.dao* tietokantayhteyksistä ja tiedostonluvusta.

Alla on sovelluksen pakkaus- ja luokkakaavio, joka kuvaa graafisesti sovelluksen rakenteen ja luokkien suhteet.

<img src="https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/Pakkaus-%20ja%20luokkakaavio.jpg">

Kuvassa esitettyjen käyttöliittymän näkymäluokkien lisäksi ohjelmaan on lisätty uloskirjautumista helpottamaan erittäin pelkistetty StartView-näkymä.

### Sovelluslogiikka

Ohjelman keskeisin rakenne on kännistettäessä luotava *CommaService*-luokan instanssi, joita on jokaisella ajokerralla ainoastaan yksi. Se tarjoaa kaikki toiminnallisuudet käyttöliittymälle ja huolehtii käyttöliittymän ja DAO-objektien välisestä tiedonvaihdosta. Se hyödyntää toiminnallisuuksien tarjoamisessa tietokantarivejä vastaavia *User*- ja *Exercise*-luokkia.

Keskeisiä comma.domain-pakkauksen luokkia vastaa toteutuksessa rajapinta ja sen toteuttava luokka seuraavasti:

| Luokka (comma.domain) | Rajapinta (comma.dao) | Rajapinnan toteuttava luokka (comma.dao) |
| --------------------- | --------------------- | ---------------------------------------- |
| Exercise              | ExerciseDao           | ExerciseDaoDb                            |
| User                  | UserDao               | UserDaoDb                                |

Nämä kokonaisuudet vastaavat keskeisiä toiminnallisuuksia, jotka liittyvät aina joko harjoitukseen, käyttäjään tai molempiin.

### Käyttöliittymä

Käyttöliittymä on toteutettu JavaFX-kirjaston avulla. Käyttöliittymän sceneihin ja näkymiin injektoidaan aina *CommaService*, jotta sen toiminnallisuudet ovat käytössä kaikkialla käyttöliittymässä.

Käyttöliittymässä vaihdellaan kolmen eri Scenen (*Login*, *Register*, *LoggedIn*) välillä. Scenejen toiminnallisuudet:
- *Login*: sisäänkirjautuminen
- *Register*: uuden käyttäjän rekisteröityminen
- *LoggedIn*: kirjautuneen käyttäjän navigointi (päävalikko) ja paikka vaihtuvalle kirjautuneen käyttäjän sisällölle

*LoggedIn*-scenen päävalikon alapuolelle generoituva näkymä vaihtelee. Tämä on toteutettu siten, että LoggedIn-scenen päänäkymässä on tila vaihtuvalle toiselle näkymälle. Tässä näkymässä vaihtelevat käyttäjän valintojen mukaan *StartView*, *PracticeView*, *FeedbackView*, *StatisticsView* ja *AddView*. View-toiminnallisuudet:
- *StartView*: hyvin pelkistetty aloitusnäkymä, joka kehottaa valitsemaan päävalikosta toiminnallisuuden.
- *PracticeView*: harjoituksen lukeminen ja suorittaminen
- *FeedbackView*: palaute harjoituksen suorittamisen jälkeen
- *StatisticsView*: käyttäjäkohtaisia tilastoja suoritetuista harjoituksista
- *AddView*: uuden tehtävän lisääminen harjoituspankkiin

Lisäksi *LoggedIn*-scenen päävalikosta on mahdollista kirjautua ulos. Toiminto nollaa *CommaServicen* käyttäjämuistin ja palauttaa *LoginScenen*.

## Tiedon tallentaminen: tietokanta ja tiedostosta luku

Sovellus lukee ja tallentaa tietoja *commas.db*-tietokannassa. Tietokannanhallintajärjestelmä on SQLite, ja siihen yhdistetään SQLite JDBC -ajurilla (tuottanut Xerial). Tietokannassa on kaksi taulua: *Exercises* ja *Users*. Tietokannan skeema:

```
CREATE TABLE Exercises (firstpart TEXT, secondpart TEXT, comma INTEGER, category INTEGER, creator TEXT);
CREATE TABLE Users (username TEXT, name TEXT, completedCtg1 INTEGER, completedCtg2 INTEGER, completedCtg3 INTEGER);
```

Tietokanta ja taulut generoidaan sovelluksen juureen käynnistettäessä, mikäli niitä ei ennestään ole olemassa. Tietokannan polku on *commas.db*. Testit luovat käyttöönsä CommaServicelle erillisen tietokannan *commasTest.db* niin ikään projektin juureen. 
Tietokannan osoite annetaan CommaServiceä luotaessa parametrina, ja tästä se valutetaan DAO-luokille, jotka huolehtivat kannan luomisesta ja siihen yhdistämisestä.

Tiedon lukemisesta ja tallennuksesta vastaavat luokat *ExerciseDaoDb* ja *UserDaoDb*, jotka toteuttavat rajapinnat *ExerciseDao* ja *UserDao* (vastaavasti). *CommaService* kutsuu luokkia rajapinnan kautta.

Sovelluksen käynnistyksen yhteydessä luokka *ExerciseDaoDb* lukee lisäksi tiedostoa Maven-resurssisijainnista: <projektin juuri>*/src/main/resources/exercises.csv*. Tiedostossa ovat ohjelmassa valmiiksi olevat harjoitustehtävät, joiden tekijäksi tietokantaan merkitään siten *ExerciseDaoDb*:ssä `program`. Valmiit tehtävät on tallennettu tiedostoon |-erottimella muodossa
```
Lauseen ensimmäinen osa|Lauseen toinen osa|1|2
```
jossa ensimmäinen ja toinen osa ovat merkkijonoja. Ensimmäinen kokonaisluku on 0 tai 1 sen mukaan, tuleeko pilkku (0=ei, 1=kyllä). Toinen kokonaisluku on 1-3 sen mukaan, mitä kategoriaa tehtävä koskee. 
  
## Tehtäväkategoriat

Sovelluksen tehtävät on tietokannassa ja olioissa luokiteltu kuuluvaksi yhteen kolmesta kategoriasta:
1. Päälausetehtävät
2. Sivulausetehtävät
3. Erikoistapaukset ja muut

Kategorioiden perusteella muun muassa tarkkaillaan, onko käyttäjä suorittanut palkintoihin oikeuttavan määrän (tällä hetkellä 5) jonkin kategorian tehtäviä.

## Toiminnallisuudet

Sovelluksen aivan keskeisin toiminnallisuus on harjoituksen hakeminen ja käyttäjän suorittama vastaus, joka menee oikein tai väärin. Alla on havainnollistavat sekvenssikaaviot siitä, mitä kummassakin tapauksessa tapahtuu. Etenkin tehtävän haku ja oikea vastaus käyttää luokkia ja ominaisuuksia varsin kattavasti.

**Tehtävän haku ja väärä vastaus**

<img src="https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/Sekvenssikaavio_vaara-vastaus.jpg">

**Tehtävän haku ja oikea vastaus**

<img src="https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/Sekvenssikaavio_oikea-vastaus.jpg">

**Uuden tehtävän syöttäminen tietokantaan**

Lisäksi sovelluksessa keskeinen ominaisuus on, että käyttäjä voi lisätä tietokantaan omia tehtäviään. Näitä hän ei voi itse ratkaista, mutta muut kirjautuneet käyttäjät näkevät tehtävät ja saavat niistä normaalisti pisteitä. Uuden tehtävän lisäys tietokantaan sujuu seuraavasti, mikäli käyttäjän syöte menee CommaServicessä toteutettavasta validoinnista läpi:

<img src="https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/Sekvenssikaavio_uusi-tehtava.jpg">

**Muut toiminnallisuudet**

Lisäksi sovellus sisältää seuraavat toiminnallisuudet:
* Yksinkertainen rekisteröityminen ja kirjautuminen. Käyttäjät tallennetaan tietokantaan selkotekstinä käyttäjänimen perusteella, salasanakirjautumista tai hashaysta ei ole toteutettu. CommaService huolehtii käyttäjänimen tarkistuksesta kirjautumisen yhteydessä ja uuden käyttäjän lisäämisestä kantaan rekisteröidyttäessä.
* Käyttäjäkohtaisten tilastojen haku. Käyttäjätauluun tallennetaan kokonaislukuina, paljonko tehtäviä kukin käyttäjä on saanut läpi kussakin kolmesta tehtäväkategoriasta. CommaService laskee käyttäjäkohtaisia tilastoja näiden perusteella tilastointinäkymässä.
* Palkinnot, kun tietty määrä kategorian harjoituksia läpäisty. CommaService tarkistaa tehtävän tarkistuksen yhteydessä, tuliko juuri tällä kerralla palkintoa (palautushetkellä palkinnon raja 5 onnistunutta tehtävää kategoriassaan). Jos tuli, käyttöliittymä ilmoittaa tästä. Lisäksi saavutetut palkinnot listataan pysyvästi tilastointinäkymään.
