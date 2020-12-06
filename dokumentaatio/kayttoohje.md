# Pilkkuharjoittelusovelluksen käyttöohje

## Ohjelman suorittaminen

Ohjelma suoritetaan lataamalla release ja ajamalla .jar-tiedoston tallennusrepositoriossa komento `java -jar <tiedostonnimi>` (sijoita tiedostonnimen paikalle lataamasi .jar-tiedoston nimi).

Ohjelman voi suorittaa myös kloonaamalla repositorion tai lataamalla projektin .zip-tiedostona. 
Tällöin sen voi suorittaa omassa JDK:ssa tai kansion *Pilkkuharjoittelu* juuressa komennolla `mvn compile exec:java -Dexec.mainClass=comma.domain.Main`

Kaikki tarpeelliset tiedostot siirtyvät pakkauksen mukana molemmissa tapauksissa.

## Rekisteröityminen, kirjautuminen ja uloskirjautuminen

Jotta sovelluksella pääsee harjoittelemaan pilkkusääntöjä, on oltava oma käyttäjä.

Käyttäjän voi luoda sovelluksen käynnistyttyä painamalla aloitusnäkymästä vaihtoehtoa *Rekisteröi uusi käyttäjä*.
Avautuvaan lomakkeeseen täytetään toivottu käyttäjätunnus ja käyttäjän koko nimi. Mikäli käyttäjätunnus on vapaa, rekisteröityminen onnistuu.
Jos rekisteröityminen ei onnistu, käyttäjätunnus on todennäköisesti varattu. Kokeile tällöin toista käyttäjätunnusta.

Kun rekisteröityminen on valmis, siirrytään *Palaa kirjautumiseen* -painikkeesta kirjautumisnäkymään.
Kirjautuminen tapahtuu syöttämällä kirjautumiskenttään käyttäjän nimi ja valitsemalla *Kirjaudu*.

Kirjautumisen onnistuttua käyttäjä siirtyy kirjautuneen käyttäjän näkymään, jossa toiminnallisuuksia voi vaihtaa ylävalikosta klikkaamalla.
Myös uloskirjautuminen tapahtuu ylävalikon kautta.

## Harjoituksen suorittaminen

Kirjautumisen jälkeen harjoituksen voi suorittaa valitsemalla ylävalikosta *Harjoittele*.
Tällöin näkymään avautuu tehtävä. Tehtävänä on päätellä, tuleeko annetun lauseen alkuosan ja annetun loppuosan väliin pilkku.
Ohjelma arpoo harjoituksen kaikista vaihtoehdoista. Painamalla uudelleen *Harjoittele* ohjelma arpoo uuden tehtävän.

Tehtävään vastataan käyttäjän parhaan taidon mukaisesti valitsemalla *Kyllä, tulee pilkku* tai *Ei, ei tule pilkkua*.
Valinnan jälkeen käyttäjä ohjautuu palautenäkymään, jossa kerrotaan, menikö vastaus oikein ja tuottiko oikea vastaus mahdollisesti palkinnon.

## Uuden harjoituksen lisääminen

Uuden tehtävän lisäysnäkymään pääsee kirjautumisen jälkeen valitsemalla *Lisää tehtävä*.
Näkymässä voi lisätä uuden tehtävän tehtävätietokantaan siellä jo olevien lisäksi.

Näkymässä täytetään seuraavat tiedot:
- **Lauseen alkuosa** on lauseen alkupuolisko ennen kysyttävää pilkun paikkaa.
- **Lauseen loppuosa** on lauseen loppupuolisko kysyttävän pilkun paikan jälkeen.
- **Tuleeko väliin pilkku?** -kohta saa arvokseen 0, jos ei tule, ja 1, jos tulee.
- **Mitä kategoriaa harjoitus on?** -kohta saa arvokseen 1, jos se testaa päälauseiden väliin tulevaa pilkkua, 2, jos se testaa sivulauseiden välissä olevaa pilkkua ja 3 muutoin.

Myös käyttöliittymä ohjaa lomakkeen täyttämisessä.

## Käyttäjätilastot

Omia käyttäjätilastoja voi tarkastella kirjautumisen jälkeen valitsemalla ylävalikosta *Käyttäjätiedot*.
