# pgo-git-start

## Opis repozytorium

Projekt laboratoryjny na przedmiot **PGO** (Programowanie Grupowe i Obiektowe)  
Polsko-Japońska Akademia Technik Komputerowych

Celem ćwiczeń jest opanowanie podstaw pracy z repozytorium Git, publikacji kodu na GitHubie,
tworzenia gałęzi oraz ich scalania.

## Autor

Imię i nazwisko: *(uzupełnij)*  
Nr indeksu: *(uzupełnij)*

## Struktura repozytorium

```
pgo-git-start/
├── README.md       # opis projektu, autor, cel ćwiczeń
└── src/
    └── Main.java   # główna klasa uruchamiająca program
```

## Gałęzie

| Gałąź | Rola |
|---|---|
| `main` | gałąź główna z aktualną wersją projektu |
| `feature/readme` | rozbudowa dokumentacji README |
| `feature/info` | dodanie klasy AppInfo z informacjami o aplikacji |

## Etapy ćwiczenia

1. **Inicjalizacja** – `git init`, dodanie plików, pierwszy commit
2. **GitHub** – połączenie z repozytorium zdalnym, `git push`
3. **feature/readme** – rozszerzenie dokumentacji, merge do main
4. **feature/info** – dodanie klasy AppInfo, merge i usunięcie gałęzi

## Podstawowe polecenia Git użyte w ćwiczeniu

```bash
git init                          # inicjalizacja repozytorium
git status                        # stan katalogu roboczego
git add <plik>                    # dodanie do staging area
git commit -m "opis"              # zapis migawki
git log --oneline                 # historia commitów
git checkout -b feature/nazwa     # nowa gałąź + przełączenie
git merge feature/nazwa           # scalenie gałęzi do bieżącej
git push -u origin main           # push z ustawieniem upstream
git branch -d feature/nazwa       # usunięcie gałęzi lokalnie
git push origin --delete feature/nazwa  # usunięcie gałęzi zdalnie
```
