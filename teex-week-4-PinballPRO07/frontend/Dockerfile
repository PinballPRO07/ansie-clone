FROM node:alpine
WORKDIR /ansie
COPY . .
RUN npm i
# --host option is needed to make it work on Docker Desktop on WSL
CMD npm run dev -- --host
