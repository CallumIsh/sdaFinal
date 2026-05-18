# Software Design and Architecture Readme

## Overview:

In this report I will walk through my Software Design and Architecture 
submission and detail the game variations and advanced features that were implemented. I will also discuss the design patterns used within the game code, and where the code adheres to SOLID principles. The architecture of the submission will also be discussed, and the report will also include a reflection of what went well during the project and what areas of the submission could be improved.

## Variations:

The first variation that was attempted was the single dice variation. This was attempted by having a RandomSingleDice class, which generated a number between 1 and 6. To then implement the double dice, a decorator in file DiceShakerDecorator was used. We also had a Fixed Dice which is used for some of the demonstration games, and dice rolls themselves are a value object. 

The next variation that was attempted was the exact end variation, where a player must land exactly on the end square, or else they'll be bounced back from the end by the number of squares they overshoot the end by. This is done using the Strategy pattern involving a movement type interface, with BasicMovement and ExactEndMovement implementing this. Basic Movement is used when a game allows for players to win on overshoot, whereas ExactEndMovement contains the logic for if a game wants exact end wins only. 

The next variation attempted was the hit rule variation, where if a player lands on a square occupied by another player, the turn is void and the player goes back to the square they occupied before the turn started. This was also done using the Strategy Pattern, with a HitRule interface, and ForfeitHitRule and NoHitRule classes implementing it. ForfeitHitRule loops through players in the game and if they share a position, it will return that in HitResult. 

The next variation attempted was the teleport rule, where if players land on a wormhole they are teleported to the other end of it. 