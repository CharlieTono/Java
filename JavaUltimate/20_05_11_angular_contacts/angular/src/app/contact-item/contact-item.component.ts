import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.css']
})
export class ContactItemComponent implements OnInit {

  @Input()
  contact: Contact;

  @Output()
  edit: EventEmitter<Contact> = new EventEmitter();

  private contactService: ContactService;

  constructor(contactService: ContactService) {
    this.contactService = contactService;
  }

  ngOnInit(): void {
  }

  onClickEdit() {
    this.edit.emit(this.contact);
  }

  onClickDelete() {
    this.contactService.delete(this.contact);
  }
}
