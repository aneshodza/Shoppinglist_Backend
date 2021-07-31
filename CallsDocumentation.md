# All the calls
## **Group**
### _Get(path = "./groups")_
This call returns all the groups that exist
### _Get(path = "./groups/{groupUrl}")_
This call returns the group with the searched url

## **Person**
#### _Get(path = "./people")_
This call returns all the groups that exist

#### _Get(path = "./people/{id}/my-groups")_
This call returns all the groups the user is in

#### _Put(path = "./people/{url}")_
This call returns the user with this url. There is no needed requestbody

#### _Post(path = "./people")_
This call needs a RequestBody with a full user. It returns a message and a code

## **Item**
#### _Get(path = "./items")_
This call returns all the groups that exist

#### _Delete(path = "./items/{id}")_
This call deletes the item with that id

#### _Put(path = "./items/{groupId}")_
This call creates a new item and takes the item as the requestBody

## **Invitation**
#### _Get(path = "./invitations")_
This call returns all invitations that exist

#### _Put(path = "./invitations/{invitedPersonURL}")_
This call creates a new invitation. It needs the person that is getting invited as the path variable and the sender and group URL as the requestbody

###### All this code was written by Anes Hodza