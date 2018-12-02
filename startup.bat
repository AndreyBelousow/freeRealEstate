@echo off
if "%~1" equ ":main" (
  shift /1
  goto main
)
cmd /d /c "%~f0" :main %*
echo ##############################################################
echo ########           Received stop signal               ########
echo ########           Stopping containers                ########
echo ##############################################################
docker-compose down
exit /b

:main
docker-compose build | tee logs\docker_build.log
docker-compose up    | tee logs\docker_run.log