# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksessa on mahdollista harjoitella suomen kielen pilkkusääntöjä eri osa-alueille jaoteltuna.
Käyttäjä voi tehdä tehtäviä, lisätä omia harjoitustehtäviä muiden tehtäväksi ja sovelluksen kehityksen edetessä seurata etenemistään omista tilastoista.
Käyttäjä voi seurata etenemistään käyttäjäkohtaisista tilastoinneista.

## Käyttäjät

Sovelluksessa on yksi käyttäjärooli, joka huolehtii kunkin käyttäjän tulosten tilastoinnista sekä siitä, että käyttäjä ei saa harjoitustehtäviksi itse lisäämiään tehtäviä.

## Käyttöliittymäluonnos

<img src="https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/vaatimusmaarittely-1000.jpg" width="1000">

## Sovelluksen toiminnallisuudet

Käyttäjän tiedot, eteneminen ja tehtävät tallennetaan tietokantaan kahteen tauluun (User ja Exercises), joista haetaan ja joihin lisätään tietoa sovelluksessa. 

Kun sovellus valmistuu, siinä on seuraavia ominaisuuksia (kevyessä tärkeysjärjestyksessä):

- Tehtävän arpominen tietokannasta käyttäjälle - TEHTY vko 3
- Palaute siitä, menikö vastaus tehtävään oikein - TEHTY vko 3
- Uuden käyttäjän luominen ( = rekisteröityminen) - TEHTY vko 4
- Kirjautuminen ja uloskirjautuminen - TEHTY vko 4
- Kaikkien näkymien luominen ja kutsuminen oikein - TEHTY vko 5
- Uuden tehtävän lisääminen tietokantaan - TEHTY vko 5
- Tilastotiedot käyttäjän etenemisestä
- Palkinnot, kun käyttäjä on saanut oikein riittävän määrän jonkin osa-alueen tehtäviä.
- Alussa olevien harjoitustehtävien lukeminen erillisestä tiedostosta kantaan - TEHTY vko 5

## Sovelluksen alustava kehittämisjärjestys

Alla oleva lista on alustava suunnitelma kehittämisen vaiheista kurssin mittaan, lähinnä työkalu kehittäjälle.

1. Tietokantataulu tehtäville, tehtävän arpominen ja palaute toimimaan. - TEHTY viikko 3
2. Graafinen tekstikäyttöliittymä ylläoleville. - TEHTY viikko 3 (Ei vielä erillistä palautenäkymää)
3. Tietokantataulu käyttäjille, käyttäjän luominen ja kirjautuminen ylläolevaan. - TEHTY viikko 4
4. Palautenäkymän eriyttäminen omaksi näkymäkseen, erilleen tehtävänäkymästä. - TEHTY viikko 5
5. Uuden tehtävän lisääminen tietokantaan. - TEHTY viikko 5
6. Arpomisen muuttaminen siten, että ei palauta omaa tehtävää.
7. Käyttäjäkohtaisten tilastojen listaaminen käyttäjän sivulla.
8. Palkintojen luominen ja lisääminen sekä käyttäjän tilastoihin että palkinnon saadessa palautusnäkymään.
9. Harjoitustehtävien alustaminen tiedoston kautta. - TEHTY vko 5
