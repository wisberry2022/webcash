@echo off

echo What is your directory name?
set /p dirname=
mkdir %dirname%
cd %dirname%