| Päivä | Aika | Tehtävät  |
| :----:|:-----| :-----|
| 31.10.| 3    | Sovelluksen vaatimusmäärittely ja alustava arkkitehtuurisuunnittelu aloitettu, maven-projekti luotu. |
| 1.11. | 4    | Suunnitelmat viimeistelty ja kirjoitettu puhtaaksi, tuotu GitHubiin, selvitetty tietokanta-asiaa ja valittu dbms. |
| 2.11. | 3    | Luotu ensimmäinen, tekstikäyttöliittymässä toimiva luokka-DAO-ketju (Exercise) suhteellisella db-polulla; konfiguroitu Main ja varmistettu kääntyminen ja ajautuminen vdi:llä. |
| 3.11  | 2    | Tietokannan sisällön listaava metodi ExcerciseDaoDb:hen; tietokantatiedoston gitignoraus ja toisaalta kansion säilyttäminen kloonausta varten. |
| 8.11. | 3    | Lisätty JavaFX-riippuvuus Maveniin, luotu ensimmäinen tyhjä Stage+Scene GUI-pakkaukseen ja testattu toimivuus etätyöpöydällä. Luotu ensimmäinen kevyt ulkoasuhahmotelma.|
| 9.11. | 5    | Ohjelman sovelluslogiikan ja graafisen käyttöliittymän rungon rakentaminen. Nyt käyttöliittymässä on perusnäkymä johon haetaan alinäkymä (toistaiseksi vain harjoittelu). Sovelluslogiikka arpoo tietokannasta yhden satunnaisen harjoituksen ja antaa sen ratkaistavaksi, palaute annetaan oikein. Sovelluslogiikka, käynnistys + mainit fiksattu. |
| 10.11.| 2    | Lisätty jacoco-riippuvuus, ensimmäinen testiluokka (sovelluslogiikan luokalle CommaService) ja ensimmäinen järkevä testi. Testattu, että jacocolla saa aikaan raportin haluttuun paikkaan. Testattu koko homman, myös jacocon, toimivuus taas virtuaalityöpöydällä. |
| 13.11.| 1    | Korjattu sovelluslogiikkaa kutsumaan DAO-rajapintaa DAO-olion sijaan, korjattu tämän jälkeen tarpeellisia poikkeuksia. |
| 16.11.| 2    | Korjattu testien poikkeukset, testattu tarpeelliset komentorivikomennot palautusta varten, testattu komentojen toimivuus virtuaalityöpöydällä. |
| 19.11.| 1    | Ohjaukseen osallistuminen ja tietokannan valmiin sisällön tallentamisen pohtiminen ohjaajan avustuksella. |
| 21.11.| 9    | User-taulun luominen kantaan, DAO-rajapinta ja -luokka sille, User-luokka sovelluslogiikkapakkaukseen ja instanssin luominen CommaService-sovelluslogiikkalukassa. Olemassaolevan harjoittelu-Scenen eriyttäminen omaksi luokakseen. Uudet Scenet kirjautumiselle ja rekisteröitymiselle. Scenejen vaihto toimimaan sujuvasti. Testaus virtuaalityöasemassa. Käyttäjän lisääminen ja kirjautuminen toimimaan käyttöliittymästä kantaan asti (uuden käyttäjän tallennus kantaan, jos käyttäjänimeä ei kannassa ennestään, ja käyttäjän haku kannasta käyttäjänimen perusteella). Luokkakaavion luominen ja dokumentaation päivittäminen. |
| 22.11.| 1    | Testikattavuuden lisääminen, käyttöliittymän jättäminen testien ulkopuolelle. |
| 26.11.| 4    | Loppujen näkymien luominen, näkymien kutsuminen oikein, palautenäkymän palautteiden välittyminen oikein, kevyt koodin siistiminen (mm. refaktoroinnin aloittaminen). |
| 29.11.| 2    | Harjoitustehtävien lukeminen kovakoodauksen sijaan omasta pipe-erotellusta tiedostostaan ja tallentaminen kantaan ExerciseDaoDb-luokassa tietokantaa alustettaessa. |
| 30.11.| 5    | Pakkauksen tekeminen ja sen selvittely, miten resursseja (exercises.csv) luodaan niin, että pysyy .jar-tiedostossa mukana. Samoin sen selvittäminen, miten ja mihin tietokanta tallennetaan siten, että käyttö onnistuu .jar-tiedostonkin kautta. |
| 1.12. | 4    | Jar-tiedoston resurssien lukemisen viimeistely. Uusi ominaisuus: käyttäjä voi lisätä uuden tehtävän kantaan. Jar-ajautumisen ja komentorivin komentojen testaus sekä omalla työpöydällä että etätyöpöydällä. |
| 2.12. | 1    | Testiluokka Exerciselle, checkstyle-korjaukset. Checkstylen ja jacocon toimivuustarkistukset ja yleinen toimivuustarkistus virtuaalityöpöydällä. |
| 5.12. | 5    | User-tietokantatauluun lisätty kirjanpito kunkin kolmen kategorian edistymisen seurantaan. Kunkin kategorian edistymisen seuranta luetaan kannasta oikein kunkin käyttäjän käyttäjätietonäkymässä (tähän meni paljon aikaa, oli paljon debuggausta). Tehty kunnollinen logout-systeemi joka nollaa käyttäjän CommaServicessä sekä tehty uusi start-näkymä käyttöliittymään - nämä siksi, että sai näyttämään oikein kunkin käyttäjän tilastot. |
| 6.12. | 4    | Poistettu reippaasti copypastekoodia eilisen jäljiltä. Onnistuneiden harjoitusten lukumäärän kirjoittaminen kantaan saatu toimimaan. Lisätty JavaDoc ja kommenetoitu sillä kaikki luokat pakkauksista comma.dao ja comma.domain. Päivitetty arkkitehtuurikuvaus (mm. lisätty uusi sekvenssikaavio onnistuneelle harjoitukselle), luotu käyttöohje ja päivitetty muu dokumentaatio ajan tasalle. |
| 7.12. | 2    | Muutettu CommaServicen kutsusta alaspäin niin, että CommaServiceä kutsuttaessa määritetään tietokannan sijainti. Määritetty testeille erillinen oma testitietokantansa: CommaServicen testit eivät siis enää testaa prod-db:llä. Nostettu testikattavuus muokkausten jälkeen 78 prosenttiin. |
| 8.12. | 2    | Koodin siistimistä ja dokumentaation täydentämistä. Kattavat komentorivitoimivuustarkistukset virtuaalityöpöydällä. Viikon 6 releasen luominen. |
| 10.12.| 2    | Lisätty ominaisuus, että käyttäjä ei saa itse lisäämiään tehtäviä. Lisätty palkintojen tarkistus palautenäkymään ja tilastonäkymään. |

**Yhteensä 67 tuntia**
