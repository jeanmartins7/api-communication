create table tab_communications
(
    tx_id_communication       varchar(255) not null ,
    dt_created                TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dt_updated                TIMESTAMP,
    tx_message                varchar(255),
    tx_contact_type           varchar(255),
    tx_device_communication   varchar(255),
    tx_status                 varchar(255),
    tx_date                   date,
    tx_time                   time,
    primary key (tx_id_communication)
);

alter table tab_communications
    add constraint UK_id_communication unique (tx_id_communication);

