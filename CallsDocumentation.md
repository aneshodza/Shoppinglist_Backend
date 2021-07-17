# All the calls
## **Group**
### _Get(path = "./groups")_
This call returns all the groups that exist

## **Person**
#### _Get(path = "./people")_
This call returns all the groups that exist

#### _Put(path = "./people/{id}/my-groups")_
This call returns all the groups the user is in

#### _Post(path = "./people")_
This call needs a RequestBody with the password and username of the user. It returns the user if the user has been found, if it didn't, it returns a user with the error message as its username

#### _Put(path = "./people")_
This call needs a RequestBody with a full user. It returns a Person with the status as it's username.

## **Item**
#### _Get(path = "./items")_
This call returns all the groups that exist

###### All this code was written by Anes Hodza