#!/bin/bash
# =============================================================
#  KOMENDY GIT – PGO Ćwiczenia 1
#  Przeklejaj blok po bloku w terminalu (Git Bash / Terminal)
# =============================================================

# ──────────────────────────────────────────
# KROK 0 – Ustaw swoje dane w Git (raz)
# ──────────────────────────────────────────
git config --global user.name  "Twoje Imię Nazwisko"
git config --global user.email "twoj@email.com"


# ──────────────────────────────────────────
# ZADANIE 1 – Repozytorium lokalne
# ──────────────────────────────────────────
# Skopiuj folder pgo-git-start w wybrane miejsce, wejdź do niego, a następnie:

git init
git status
git add README.md src/Main.java
git commit -m "Inicjalizacja repozytorium i dodanie struktury projektu"


# ──────────────────────────────────────────
# ZADANIE 2 – Publikacja na GitHub
# ──────────────────────────────────────────
# 1. Wejdź na https://github.com/new
# 2. Utwórz publiczne repo o nazwie: pgo-git-start
# 3. NIE zaznaczaj "Add a README file"
# 4. Skopiuj URL repo (np. https://github.com/TWOJ_LOGIN/pgo-git-start.git)
# 5. Podstaw go poniżej:

git remote add origin https://github.com/TWOJ_LOGIN/pgo-git-start.git
git remote -v
git push -u origin main


# ──────────────────────────────────────────
# ZADANIE 3 – Gałąź feature/readme
# ──────────────────────────────────────────
git checkout -b feature/readme

# README.md jest już gotowy (pobrałeś go z pliku) – możesz też coś dopisać
git add README.md
git commit -m "Rozszerzenie README i aktualizacja pliku startowego"

git checkout main
git merge feature/readme
git push


# ──────────────────────────────────────────
# ZADANIE 4 – Gałąź feature/info + AppInfo
# ──────────────────────────────────────────
git checkout -b feature/info

# Skopiuj src/AppInfo.java do swojego folderu src/ (jeśli jeszcze tego nie zrobiłeś)
git add src/AppInfo.java src/Main.java
git commit -m "Dodanie pomocniczej informacji o aplikacji"
git push -u origin feature/info

git checkout main
git merge feature/info
git push

# Sprzątanie – usunięcie gałęzi
git branch -d feature/info
git push origin --delete feature/info


# ──────────────────────────────────────────
# ZADANIE OPCJONALNE – Konflikt
# ──────────────────────────────────────────
git checkout -b feature/conflict-a
# Zmień ręcznie np. linię "Autor" w README.md, zapisz, potem:
git add README.md
git commit -m "Zmiana autora w gałęzi conflict-a"

git checkout main
git checkout -b feature/conflict-b
# Zmień TĘ SAMĄ linię inaczej w README.md, zapisz, potem:
git add README.md
git commit -m "Zmiana autora w gałęzi conflict-b"

git checkout main
git merge feature/conflict-a   # OK – brak konfliktu
git merge feature/conflict-b   # KONFLIKT!

# Otwórz README.md, usuń znaczniki <<<<<<, =======, >>>>>>>
# Zostaw wersję, która ma zostać w main
git add README.md
git commit -m "Ręczne rozwiązanie konfliktu w README"
git push

# ──────────────────────────────────────────
# Sprawdzenie historii
# ──────────────────────────────────────────
git log --oneline --graph --all
