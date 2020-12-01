# Pilkkuharjoittelusovellus

Sovelluksen avulla käyttäjä voi harjoitella suomen kielen pilkkusääntöjä. 
Myöhemmässä vaiheessa sovelluksessa käyttäjä voi myös seurata omaa edistymistään ja kerätä palkintoja ratkoessaan tehtäviä onnistuneesti.

Sovellus on osa Helsingin yliopiston tietojenkäsittelytieteen Ohjelmistotekniikka-kurssin syksyn 2020 suoritusta.

## Käyttöohje tällä hetkellä

Tällä hetkellä sovellus aukeaa kirjautumisnäkymään. Kirjautumisnäkymä, rekisteröitymisnäkymä ja harjoittelunäkymä vaihtelevat napeista "Rekisteröi uusi käyttäjä", "Palaa kirjautumiseen" ja "Kirjaudu".

Sisäänkirjautumis- ja rekisteröitymisnäkymien välillä voi tällä hetkellä vaihtaa vapaasti napista painamalla.
Rekisteröitymisnäkymässä uuden käyttäjän lisääminen lisää kantaan uuden käyttäjän (olettaen, että rekisteröityminen onnistuu, eli mm. ettei samannimistä käyttäjää ole kannassa ennestään).

Sisäänkirjautumisnäkymästä pääsee harjoittelunäkymään kirjautumalla sisään olemassaolevalla käyttäjänimellä.

Tehtävässä on toistaiseksi kolme tiedostosta kantaan luettua esimerkkitehtävää, ellei käyttäjä ole lisännyt itse lisää. Harjoittelunäkymässä uuden tehtävät saa arvottua painamalla "Harjoittele", ja palaute näytetään palautenäkymässä. 

Uuden tehtävän lisäysnäkymässä käyttäjä voi lisätä tehtävän, joka lisätään tietokantaan ja arvotaan sitten muiden tehtävien mukana (tulevaisuudessa niin, ettei käyttäjä voi saada itse lisäämäänsä tehtävää). Käyttäjätilastonäkymä on luotu, mutta sisältöä siinä ei vielä ole.

Uloskirjautuminen palauttaa kirjautumisnäkymään.

## Releaset

[Viikko 5](https://github.com/sallasal/Ohte-2020/releases/tag/viikko5)

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/vaatimusmaarittely.md)

## Vaatimukset ja suorittaminen

Sovellus vaatii toimiakseen Javan version 11. Sovellus käyttää Mavenia ja kolmannen osapuolen kirjastoja.

Koodin ja testit voi ajaa Netbeans-ohjelmointiympäristössä tai komentoriviltä. Netbeans-ympäristössä ajaminen tapahtuu vihreästä nuolesta tai valikosta `Run`: `Run project (Pilkkuharjoittelu)`. Testit ajetaan Netbeansissa valitsemalla samasta valikosta `Test project (Pilkkuharjoittelu)`.

Alla luetellut komentorivikomennot ajetaan projektikansiosta `Pilkkuharjoittelu`.

### Komentorivikomennot

Sovelluksen käynnistäminen:

```
mvn compile exec:java -Dexec.mainClass=comma.domain.Main
```

Sovelluksen testien ajaminen:
```
mvn test
```

Testiraportin luominen projektikansion sijaintiin `target/site/jacoco/index.html`:
```
mvn jacoco:report
```

Checkstyle-raportin luominen projektikansion sijaintiin `target/site/checkstyle.html`:
```
mvn jxr:jxr checkstyle:checkstyle
```

.jar-pakkauksen luominen
```
mvn package
```
