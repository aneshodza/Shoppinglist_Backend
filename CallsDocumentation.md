# All the calls
This file documents all the API calls
## **Group**
### _Get(path = "./groups")_
This call returns all the groups that exist

### _Get(path = "./groups/{groupUrl}")_
This call returns the group with the searched url

### _Put(path = "./groups/{groupUrl}")_
This call creates a new group. It needs the group as the RequestBody and the creators URL as the PathVariable

## **Person**
#### _Get(path = "./people")_
This call returns all the groups that exist

#### _Get(path = "./people/{id}/my-groups")_
This call returns all the groups the user is in

#### _Get(path = "./people/{url}")_
This call returns the user with this url. There is no needed RequestBody

#### _Post(path = "./people")_
This call needs a RequestBody with a full user. It returns a message and a code. It servers as an Sign Up call

#### _Put(path = "./people")_
This call needs the person as the RequestBody. It serves as a LogIn call

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

#### _Post(path = "./invitations")_
This call needs a RequestBody with the invitations ID and wether the invitation has been accepted or not

###### All this code was written by Anes Hodza