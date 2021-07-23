WatchList:
**Watch lists differ from other kinds of categories (as groups, markets, industries, sectors) in that, that you can assign single symbol to more than one watch list.

**You can use UNLIMITED number of watch lists with their names definable in Symbol->Categories window. The members of each watch list is shown in the symbol tree under "Watch lists" leaf.

**Watch lists are now stored as text files inside "Watchlists" folder inside database. The folder contains of any number of .TLS files with watch lists themselves and index.txt that defines the order of watch lists. You can add your own .tls file (one symbol per line) and AmiBroker will update index.txt automatically (adding any new watch lists at the end)The .TLS files can also be open in AmiQuote.

**Watch lists remember the order in which symbols were added, so for example if you sort AA result list in some order and then you"add symbols to watch list" the order will be kept in the watch list.
Adding / removing watch lists

**You can now Add/Delete watch lists using Symbol->Watch List->New Watchlist and Symbol->Watch List->Delete Watch list menu or from watch list context menu. Note that if you have done any customization to the menu, you may need to go to Tools->Customize, select "Menu Bar" and press "Reset" button for this new menu items to appear.

**When you choose Add all/selected results to watch list a watch list selector will appear where you select to which list symbols should be added, then after clicking OK all symbols filtered by your trading rules will automatically appear in the watch list of your choice.

**You can also use option Replace watch list with the results/selected results

**This new option empties the watch list before adding results. The order of symbols in the result list is preserved in the watch list

To solve the problem, you need to complete the following steps:

Note: Classes provided in this exercise will show compilation errors when the exercise is cloned locally.

You need to go through the comments thoroughly and complete the application.

**Add the required dependency for MongoDB in pom.xml.
**Add properties in application.properties for WatchList-Service.
**Test in Postman to see if you can access the WatchList-Service through the MongoDB.