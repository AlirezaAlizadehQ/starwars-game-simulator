# starwars-game-simulator



# Objectives and project description
Star Wars Game Simulator is part of a university group project. 
The objective of this project was to work in pairs and extend the existing software system 
abiding by the object-oriented design principles. We were required to collaborate using git, design principles and using of standard UML diagrams.
This project is a multi-class Java game and initially was provided with a large codebase for a text-based game in the starwars universe.



# Gameplay
Here are listed some of the features of the game:

Leave Affordance
Some entities have a Take affordance (e.g. lightsabres, blasters).
Add a Leave affordance that allows an actor to put down the object they are currently carrying.

Force ability
Some, but not all, people (including Ben and Luke) have the ability to use the Force.

Lightsabres
Anybody can pick a lightsabre up, but only people with a lot of Force ability can wield one and use it
as a weapon.

Ben Kenobi
Ben can train Luke when they are in the same location. Training Luke has the effect of raising his force
ability to the extent that Luke can wield a lightsabre.

Droids
Droids can’t use the Force.
A droid can have another actor as its owner. If a droid has an owner:
• if it is in the same location as its owner, it will stay there. If the droid’s owner is in a neighbouring
location, it will move to that location.
• if it cannot find its owner in its current or neighbouring locations, it will pick a direction at random
and move in that direction. It will keep moving in that direction until it finds its owner, or can no
longer move in that direction. If it can no longer move in its current direction, it will pick a new
direction at random and move in that direction.
If a droid has no owner, it will not move.
Droids lose health when they move in Badlands.
Droids don’t die, but they become immobile when their health runs out

Reservoirs damageable
• If the hitpoints of a reservoir fall below 20, its short description must change to “a damaged water
reservoir”, its long description must change to “a damaged water reservoir, leaking slowly”, and
its symbol must change to V.
• If the hitpoints of a reservoir fall to zero or below, its short description must change to “the wreck-
age of a water reservoir”, its long description must change to “the wreckage of a water reservoir,
surrounded by slightly damp soil”, and its symbol must change to X

Grenade
A grenade is an item that can be taken by an actor. After it is taken, it can be either put down again
(with a leave command), or thrown. When a grenade is thrown, it explodes violently, doing damage to
both actors and other entities, in “rings” of differing severity. It should cause damage as follows:
• Entities in the location where the grenade is thrown lose 20 hitpoints.
• Entities in locations that can be reached in one step from the location where the grenade is thrown
lose 10 points.
• Entities in locations that can be reached in two steps from the location where the grenade is thrown
lose 5 points.
• The actor that throws the grenade is not affected.
After a grenade is thrown, it is completely destroyed and disappears.

Jawa Sandcrawler
Jawas are small creatures that scavange the planet Tatooine for droids and other scrap material to use
for trade. They travel in a vehicle called a “sandcrawler”. Create a Sandcrawler with the following
functionality:
• A sandcrawler moves in the same way as Ben Kenobi, but only moves every second turn.
• If a sandcrawler finds a droid in its location, the droid is taken inside the sandcrawler.
• A sandcrawler has a door that can be entered by any actor with force ability that is in the same
location as the sandcrawler. When the actor enters the sandcrawler, the actor moves to the interior
of the sandcrawler, which is a grid of at least four locations. 1
– All the droids taken by the sandcrawler must be in one of these interior locations.
– One of the interior locations must have a door that can be user by any actor with force ability
that is in that location. Exiting the door results in the actor being returned to the location in
which the sandcrawler is located.



## Plagiarism Notice
The code in this repository is not endorsed by Monash University. Please note that copying the code for unit assessments without referencing will result in a breach in Academic Integrity Policy and that the author @AlirezaAlizadehQ will not be held responsible for these breaches. For more information please visit https://www.monash.edu/students/academic/policies/academic-integrity
