#!/bin/sh

if [    "$TRAVIS_PULL_REQUEST" = "false" -a \
        "$TRAVIS_BRANCH" = "master" ]
then

  echo "Publishing javadoc..."

  cp -R target/site/apidocs $HOME/apidocs

  cd $HOME
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"
  git clone --quiet --branch=master https://${GH_TOKEN}@github.com/marcjasz/marcjasz.github.io gh-pages > /dev/null

  cd gh-pages
  git rm -rf ./travis-javadoc-test/apidocs
  mkdir -p ./travis-javadoc-test/apidocs
  cp -Rf $HOME/apidocs ./travis-javadoc-test
  git add -f .
  git commit -m "Latest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
  git push -fq origin master > /dev/null

  echo "Published Javadoc to gh-pages."

fi
