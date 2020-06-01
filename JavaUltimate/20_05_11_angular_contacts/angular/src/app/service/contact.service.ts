import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ContactService {
  private host = 'http://localhost:8090/';

  contacts: Observable<Contact[]>;

  constructor(private httpClient: HttpClient) {
  }

  add(contact: Contact): void {
    this.httpClient.post(`${this.host}contact`, contact)
      .subscribe(value => this.reloadContacts());
  }

  private reloadContacts() {
    this.contacts = this.httpClient.get<Contact[]>(`${this.host}contact`);
  }

  getAll(): Observable<Contact[]> {
    if (!this.contacts) {
      this.reloadContacts();
    }
    return this.contacts;
  }

  edit(contact: Contact) {
    this.httpClient.put<Contact>(`${this.host}contact`, contact)
      .subscribe(value => this.reloadContacts());
    // const contactToEdit = CONTACTS.find(value => value.id === contact.id);
    // Object.assign(contactToUpdate, contact);
  }

  delete(contact: Contact) {
    this.httpClient.delete(`${this.host}contact/${contact.id}`)
      .subscribe(value => this.reloadContacts());
    // const indexToDelete = CONTACTS.findIndex(value => value.id === contact.id);
    // CONTACTS.splice(indexToDelete, 1);
  }

}
