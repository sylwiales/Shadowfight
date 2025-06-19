# Shadowfight - Projekt zaliczeniowy

## Opis gry
**Shadowfight** to strategiczna gra turowa napisana w języku Java, w której gracz wciela się w dowódcę drużyny wojowników. Celem jest rekrutacja towarzyszy, walka z różnorodnymi przeciwnikami i zarządzanie drużyną w dynamicznych starciach. Gracz musi dostosowywać taktykę do typów ataków (sieczne, przebijające, obuchowe, magiczne) oraz wykorzystywać efekty specjalne, takie jak paraliż czy leczenie.

## Kluczowe funkcje
- **System walki turowej**: Gracz wybiera akcje (atak, leczenie) dla każdego członka drużyny.
- **Różnorodne postacie**: Każdy towarzysz ma unikalne statystyki (siła, zdrowie) i typ ataku.
- **Efekty specjalne**: Ataki magiczne mogą sparaliżować przeciwników, a leczenie przywraca zdrowie lub usuwa paraliż.
- **Przeciwnicy**: Potwory różnią się zachowaniem i słabościami.
- **Interfejs tekstowy**: Gra działa w konsoli z kolorowym tekstem i menu.

## Struktura projektu
- **/art**: Zawiera grafiki ASCII wyświetlane w grze. Wszystkie wykorzystane w projekcie grafiki pochodzą ze strony internetowej [ASCII Art Archive](https://www.asciiart.eu).
- **/characters**: Definiuje postacie (towarzyszy i potwory) oraz ich mechaniki.
- **/game**: Zarządza logiką gry, walką i menu.
- **/utils**: Narzędzia pomocnicze (formatowanie tekstu, kolory, czyszczenie ekranu).

## Uruchomienie
1. Skompiluj projekt: `javac src/main/java/game/Main.java -d out/production/gra_project`.
2. Uruchom grę: `java -cp out/production/gra_project game.Main`.
3. Alternatywnie, użyj pliku `run.bat` (Windows).

## Autorzy
- Matylda Dylag
- Sylwia Leśniak

## Zrzuty ekranu z gry
### Ekran tytułowy
![image](https://github.com/user-attachments/assets/d9117f1d-46eb-4265-953c-e67321b21376)

### Zbierz swoją drużynę
![image](https://github.com/user-attachments/assets/7558f049-b6b8-4809-97ce-505f0f43b880)

### Spotkaj różnych przeciwników
![image](https://github.com/user-attachments/assets/80930084-c206-42ea-a2a3-514a3dcaf336)
![image](https://github.com/user-attachments/assets/c4788417-9a16-4cc9-9652-93a28ecef5a4)

### Odkrywaj słabości przeciwników
![image](https://github.com/user-attachments/assets/869c3c9c-d18f-48c0-95f3-6aeb96a7d35b)

### Postaraj się nie przegrać
![image](https://github.com/user-attachments/assets/a2d8a72a-926e-4caa-b233-d099c944d3be)





