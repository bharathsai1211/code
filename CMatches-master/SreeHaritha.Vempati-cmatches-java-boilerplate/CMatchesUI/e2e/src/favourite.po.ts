import { browser, by, element } from 'protractor';

export class FavouritePage {

    getTitleText() {
        return element(by.css('h1'));
      }


}