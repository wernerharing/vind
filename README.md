# VIND

Vind (faɪnd) is a modular Java library which aims to lower the hurdle of integrating information discovery facilities in Java projects.
It should help programmers to come to a good solution in an assessable amount of time, improve the 
maintainability of software projects, and simplify a centralized information discovery service management including monitoring and reporting.

[![Build Status](https://travis-ci.org/RBMHTechnology/vind.svg?branch=master)](https://travis-ci.org/RBMHTechnology/vind)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.rbmhtechnology.vind/vind/badge.png)](https://maven-badges.herokuapp.com/maven-central/com.rbmhtechnology.vind/vind)
[![Javadocs](https://www.javadoc.io/badge/com.rbmhtechnology.vind/vind.svg)](https://www.javadoc.io/doc/com.rbmhtechnology.vind/vind)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Gitter chat](https://badges.gitter.im/gitterHQ/gitter.png)](https://gitter.im/RBMHTechnology/vind)

## Design principles

In Vind we try to design an API which follows this 3 design principles:

**1. Versatility:** Vind will be used in many different projects, so it was an aim to keeping the dependency footprint small, 
which avoids version-clashes in the downstream projects.

**2. Backend Agnostic:** Wherever possible and feasible, the library has to abstracted from the basic search framework. This enabled us to change the
backend without migrating application software.

**3. Flat learning curve:** It was an aim to keep the learning curve rather flat, so we tried to use Java built-in constructs whenever possible. Additionally
we tried to follow the concept: easy things should be easy, complex things can (but does not have to) be complex.

The search lib is modular and currently implements the following layers:

![Search Lib Architecture](./docs/images/layer_cake.png)

## Roadmap

If you'd like to get a deeper look into the lib or if you are interested in our future goals just [have a look at 
our blog series](https://rbmhtechnology.github.io/vind/blog/).
There we give an outlook on the next development steps and introduce new features.

## How to use

The modules of the Vind lib are provided as Maven artifacts and thus can be seamlessly integrated in new and existing Java Software
projects. Vind decouples API and the *real* indexing components. The first backend which is also the reference implementation is build
on top of [Apache Solr](http://lucene.apache.org/solr/). The lib integrates an in-memory indexer on top of an Embedded Solr Server 
which enables developers to start without setting up a complex infrastructure. Furthermore Vind includes a backend maintainance component
which makes it easy to setup Vind index collections and keep them in sync with the Vind version.

[Get a detailed documentation of all functions and features](https://rbmhtechnology.github.io/vind/) 
or [dive deeper in the API of the Vind with Javadoc](https://www.javadoc.io/doc/com.rbmhtechnology.vind/vind). 

## How to contribute

Vind is an Open Source project so everyone is encouraged to improve it. Don't hesitate to report bugs, provide fixes or
share new ideas with us. We have various ways for contribution:

* use the issue tracker - report bugs, suggest features or give hints how we can improve the documentation.
* discuss issues with the community - two brains are better than one.
* write code - no patch is too small. So even fixing typos helps to improve Vind.

## License
Free use of this software is granted under the terms of the Apache License Version 2.0.
See the [License](LICENSE) for more details.

## Authors
Vind is lead by [Red Bull Media House Technology](https://github.com/RBMHTechnology) and was initiated in 2017.

## Changelog
The [Changelog](https://rbmhtechnology.github.io/vind/changelog) provides a complete list of changes in older releases.
