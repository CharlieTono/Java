import {EventEmitter, Injectable} from '@angular/core';
import {Contact} from '../model/contact';
import {Subscribable, Subscription} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContactEventService {

  private host = 'http://localhost:8090/';

  editContactEvent: EventEmitter<Contact> = new EventEmitter<Contact>();

  constructor() { }

  emitEditContact(contact: Contact): void{
    this.editContactEvent.emit(contact);
  }

  subscribeEditContact(callback): Subscription {
   const subscription: Subscription = this.editContactEvent.subscribe(callback);
   return subscription;
  }

}
