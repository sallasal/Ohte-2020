# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksessa on mahdollista harjoitella suomen kielen pilkkusääntöjä eri osa-alueille jaoteltuna.
Käyttäjä voi tehdä tehtäviä, lisätä omia harjoitustehtäviä muiden tehtäväksi ja sovelluksen kehityksen edetessä seurata etenemistään omista tilastoista.
Käyttäjä voi seurata etenemistään käyttäjäkohtaisista tilastoinneista.

## Käyttäjät

Sovelluksessa on yksi käyttäjärooli, peruskäyttäjä. Käyttäjärooli huolehtii kunkin käyttäjän tulosten tilastoinnista kategorioittain, ja tilastointi mahdollistaa myös käyttäjäkohtaisen palkintojen laskemisen. Lisäksi käyttäjärooli varmistaa, että käyttäjälle ei arvota hänen itsensä lisäämiä harjoitustehtäviä (eli että käyttäjän lisäämät tehtävät näkyvät vain muille).

## Käyttöliittymäluonnos

Käyttöliittymän toiminnallisuusvaatimukset ja näkymäluonnokset on kuvattu seuraavassa kaaviossa (klikkaa [tästä](https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/Kayttoliittymaluonnos.jpg) nähdäksesi kaavion suurempana). Näkymissä harmaat elementit kuvaavat painonappeja ja valkoiset elementit syöttökenttiä. Elementit ilman taustaa ovat ohjelman käyttöliittymään tulostamaa tekstiä. Kirjautumisen jälkeen esiin tulevan valikon toiminnallisuus on selostettu kuvaajassa.

<img src="https://github.com/sallasal/Ohte-2020/blob/master/dokumentaatio/media/Kayttoliittymaluonnos.jpg">

## Sovelluksen toiminnallisuudet

Käyttäjän tiedot, eteneminen ja tehtävät tallennetaan tietokantaan kahteen tauluun (User ja Exercises), joista haetaan ja joihin lisätään tietoa sovelluksessa. 

Kun sovellus valmistuu, siinä on seuraavia ominaisuuksia (kevyessä tärkeysjärjestyksessä):

- Tehtävän arpominen tietokannasta käyttäjälle - TEHTY vko 3
- Palaute siitä, menikö vastaus tehtävään oikein - TEHTY vko 3
- Uuden käyttäjän luominen ( = rekisteröityminen) - TEHTY vko 4
- Kirjautuminen ja uloskirjautuminen - TEHTY vko 4
- Kaikkien näkymien luominen ja kutsuminen oikein - TEHTY vko 5
- Uuden tehtävän lisääminen tietokantaan - TEHTY vko 5
- Tilastotiedot käyttäjän etenemisestä: lukee tietokannasta oikein tehdyt tehtävät - TEHTY vko 6
- Tilastotiedot käyttäjän etenemisestä: päivittää tietokannan onnistumisen yhteydessä. - TEHTY vko 6
- Ohjelma ei arvo käyttäjälle tämän itse tekemiä tehtäviä. - TEHTY vko 7
- Palkinnot, kun käyttäjä on saanut oikein riittävän määrän jonkin osa-alueen tehtäviä. - TEHTY vko 7
- Alussa olevien harjoitustehtävien lukeminen erillisestä tiedostosta kantaan - TEHTY vko 5

## Jatkokehitys

Ohjelmaa olisi helposti mahdollista kehittää edelleen esimerkiksi seuraavilla ominaisuuksilla:

- **Monentasoisia palkintoja.** Palkintoja voisi olla eri tasoisia ja eri nimisiä sen mukaan, kuinka paljon tehtäviä kustakin kategoriasta on suoritettuna. Tällä hetkellä kustakin kategoriasta on mahdollista ansaita vain yksi palkinto viiden oikein ratkaistun tehtävän jälkeen, mutta uusia palkintoja voisi tulla esim. 5, 10, 25 ja 50 tehtävän kohdalla. Tämä olisi käyttäjälle mukava ominaisuus ja helppo toteutettava, mutta vaatisi runsaasti suuremman valmiin harjoituspankin valmiiksi tuotavia harjoituksia. Tällä hetkellä harjoitustehtäviä on valmiina vain parikymmentä.
- **Selite tehtävän yhteyteen.** Kun tehtävä ratkaistaisiin oikein, palautenäkymässä voisi olla myös selite juuri tässä tehtävässä olennaisista kielioppisäännöistä. Tämä olisi kannassa suoraviivainen toteuttaa omalla sääntötaulullaan ja ohjauksella siihen kultakin harjoitustaulun riviltä. Selitys oikean vastauksen jälkeen olisi paras kohta, sillä ennen oikeaa vastausta harjoituksesta tulisi liian helppo. Samat tehtävät pyörivät harjoituksessa joka tapauksessa, joten ennen pitkää vaikea tehtävä tulee kyllä uudelleen vastaan.
- **Oikein ratkaistut tehtävät eivät toistu.** Nyt ohjelmassa toistuvat myös oikein ratkaistut tehtävät harjoiusarvonnassa. Olisi mahdollista suunnitella kirjanpito siitä, mitkä tehtävät käyttäjä täsmälleen on ratkaissut oikein, ja huolehtia, että ne eivät toistu hänen harjoituksissaan. Tämä voi kuitenkin nykyisellä arkkitehtuurilla vaatia varsin paljon näpertelyä.
- **Opettaja-käyttäjärooli.** Ohjelmaan voisi toteuttaa suuremmilla oikeuksilla varustetun Opettaja-käyttäjäroolin, joka näkisi kaikkien harjoitusten tekijöiden edistymisen ja voisi myös tehdä tarvittaessa käyttäjänhallintaa (esimerkiksi poistaa asiattomia tilejä tai huijausta varten tehtyjä tilejä).
- **Salasanahallittu, suojattu kirjautuminen.** Tämän toteuttaminen olisi luonnollinen askel kirjautumisen kehittämisessä.
