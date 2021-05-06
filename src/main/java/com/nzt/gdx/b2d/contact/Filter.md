## Function Box2D 
bool collide = (filterA.maskBits & filterB.categoryBits) != 0 &&
(filterA.categoryBits & filterB.maskBits) != 0;
