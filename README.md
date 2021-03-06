# Pilkkuharjoittelusovellus

Sovelluksen avulla käyttäjä voi harjoitella suomen kielen pilkkusääntöjä. 
Käyttäjä voi myös seurata omaa edistymistään ja kerätä palkintoja ratkoessaan tehtäviä onnistuneesti.

Sovelluksen toiminnallisuudet ovat valmiit, dokumentaatio ja ulkoasu vielä viilattavana.
Tällä hetkellä sovelluksessa on parikymmentä esimerkkitehtävää valmiina, ja **palkintojen myöntämisraja on 5 onnistunutta tehtävää kategoriassaan**.

Sovellus on osa Helsingin yliopiston tietojenkäsittelytieteen Ohjelmistotekniikka-kurssin syksyn 2020 suoritusta. Uusin release on projektin loppupalautus.

## Uusin release

[Loppupalautus](https://github.com/sallasal/Ohte-2020/releases/tag/loppupalautus)

**Vanhemmat vakaat versiot**

[Viikko 6](https://github.com/sallasal/Ohte-2020/releases/tag/viikko6)

[Viikko 5](https://github.com/sallasal/Ohte-2020/releases/tag/viikko5)

## Dokumentaatio

[Arkkitehtuurikuvaus](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/testausdokumentti.md)

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
mvn test jacoco:report
```

Checkstyle-raportin luominen projektikansion sijaintiin `target/site/checkstyle.html`:
```
mvn jxr:jxr checkstyle:checkstyle
```

.jar-pakkauksen luominen
```
mvn package
```

.jar-pakkauksen ajaminen
```
java -jar <tiedostonnimi>
```

JavaDoc-raportin luominen sijaintiin `target/site/apidocs` (**poista ensin vanha**, jos olet luonut raportin jo aiemmin!)
```
mvn javadoc:javadoc
```
