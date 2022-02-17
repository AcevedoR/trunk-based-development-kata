# trunk-based-development-kata
## Usage
Java 17 needed

`./mvnw spring-boot:run -f web/pom.xml`

## Disclaimer
This project was made for a quick demo, some code and config may be ugly, and broken

## kata
Demonstrating some techniques to push a feature in small batches.
All of your commits should be prod-ready.

Let's imagine that all our development are really long (more than one day), and we try to split them (commit each day at least once to prod).

### Branch by abstraction: rework IPA type rule
**Branch by abstraction** is useful when we want to completely replace code, with an abstraction.

**Context:** We want to rework the rule determining an IPA type

**Exercice:** rework IPARule, let's say a Double IPA is not between 6-10 alcohol and 70-100 ibu (previously 7-10 and 80-100)

Create an abstraction around the code to be replaced and commit.
Implement the new code (with dedicated test) and commit.
Remove the old code and commit.

### Dark launching: expose POST /beers/rate
**Dark launching** may be a fancy word for developing back-end first (implementation), and then climb up progressively to the front-end (what is exposed).

**Context:** We already started a new **feature**: we can *Rate a Beer*.

One basic implementation was started, and pushed to production without any issue, since it is not wired and exposed, yet.

**Exercise:** expose the *Rate a Beer* feature as a new endpoint, and commit it.

### Feature toggle: rating forbidden in working hours
**Feature toggle:** parametrize enabling of a feature

**Context:** we want to forbid users to rate a beer during working hours (09-17h), but this is a critical and already exposed feature

**Exercise:** implement a quick and naive datetime check when creating a Rate, but only when property `com.zenika.tz.trunkkata.rating.working-hours-check: true`
