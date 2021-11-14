## Make PDF

```bash
docker-compose run latex /bin/bash
cd /home/user/content/texlive-full/
make gpi-build-rep
exit
docker-compose down
```

or

```bash
docker-compose up
docker-compose down
```

## Cleaning the project

```bash
make gpi-clean
```
