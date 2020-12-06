# Pilkkuharjoittelusovellus

Sovelluksen avulla käyttäjä voi harjoitella suomen kielen pilkkusääntöjä. 
Myöhemmässä vaiheessa sovelluksessa käyttäjä voi myös seurata omaa edistymistään ja kerätä palkintoja ratkoessaan tehtäviä onnistuneesti.

Sovellus on osa Helsingin yliopiston tietojenkäsittelytieteen Ohjelmistotekniikka-kurssin syksyn 2020 suoritusta.

**Ohjelmassa on vielä puutteita: se ei esimerkiksi vielä validoi käyttäjän syötteitä (joten käytä lempeästi).**

Ohjelma valmistuu joulukuussa 2020.

## Releaset

[Viikko 5](https://github.com/sallasal/Ohte-2020/releases/tag/viikko5)

## Dokumentaatio

[Arkkitehtuurikuvaus](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/kayttoohje.md)

[Työaikakirjanpito](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/vaatimusmaarittely.md)

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

JavaDoc-raportin luominen (**poista ensin vanha**, jos olet luonut raportin jo aiemmin!)
```
mcn javadoc:javadoc
```
