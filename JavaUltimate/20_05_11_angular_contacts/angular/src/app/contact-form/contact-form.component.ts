import {Component, Input, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';
import {ContactEventService} from '../service/contact-event.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  contact: Contact;

  isAddingState: boolean;
  editContactsSubs: Subscription;

  constructor(private contactService: ContactService, private contactEventService: ContactEventService) {
  }

  ngOnInit(): void {
    this.clearForm();
    this.editContactsSubs = this.contactEventService.subscribeEditContact((value => this.onEditContact(value)));
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnDestroy(): void {
    this.editContactsSubs.unsubscribe();
  }

  onEditContact(value: Contact) {
    Object.assign(this.contact, value);
    this.isAddingState = false;
  }

  onClickAdd() {
    console.log(this.contact);
    this.contactService.add(this.contact);
    this.clearForm();
  }

  clearForm() {
    this.contact = new Contact();
    this.isAddingState = true;
  }

  onClickEdit() {
    this.contactService.edit(this.contact);
    this.clearForm();
  }

  onClickCancel() {
    this.clearForm();
  }
}
