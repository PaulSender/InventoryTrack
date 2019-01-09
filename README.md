## Inventory Tracking

### App Description
This application tracks made up stats about a hardware store's item and 
it's make believe customers. It is broken up into five parts: Add, Rent, Lookup, Print Manifest, and Current Inventory.
The Add feature adds a new item or a new customer to either Inventory.JSON or Customers.JSON respectively. Rent displays
the currently rented out items with customers names attached to whatever item they have rented. Lookup is a simple feature that
allows the user to look up equipment by ID, Name, or Tag and displays them in alphabetical order along with the inventory level 
for those items. Print Manifest prints out the balance for all customers and what items are currently being rented. Finally, 
a user can view a summary of inventory levels for items remaining in the system with Current Inventory. 

### Getting started

#### Installation for Dev Environment
1. Make sure you've installed JDK 8 and Android Studio, a Standard Setup would work.
2. Clone this GitHub repository.
3. In Android Studio click File--> New--> Project From Version Control --> GitHub. Paste the link in Git Repository URL.
4. The Application uses API 21 Lollipop. I prefer the Pixel Emulator and API 28 in the editor. Changing emulators may affect some styling.
