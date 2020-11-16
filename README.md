# Pilkkuharjoittelusovellus

Sovelluksen avulla käyttäjä voi harjoitella suomen kielen pilkkusääntöjä. 
Myöhemmässä vaiheessa sovelluksessa käyttäjä voi myös seurata omaa edistymistään ja kerätä palkintoja ratkoessaan tehtäviä onnistuneesti.

Sovellus on osa Helsingin yliopiston tietojenkäsittelytieteen Ohjelmistotekniikka-kurssin syksyn 2020 suoritusta.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/sallasal/Ohte-2020/blob/master/Pilkkuharjoittelu/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/sallasal/Ohte-2020/blob/master/Pilkkuharjoittelu/dokumentaatio/tyoaikakirjanpito.md)

## Vaatimukset ja suorittaminen

Sovellus vaatii toimiakseen Javan version 11. Sovellus käyttää Mavenia ja kolmannen osapuolen kirjastoja.

Koodin ja testit voi ajaa Netbeans-ohjelmointiympäristössä tai komentoriviltä. Netbeans-ympäristössä ajaminen tapahtuu vihreästä nuolesta tai valikosta `Run`: `Run project (Pilkkuharjoittelu)`. Testit ajetaan Netbeansissa valitsemalla samasta valikosta `Test project (Pilkkuharjoittelu)`.

Alla luetellut komentorivikomennot ajetaan projektikansiosta.

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
