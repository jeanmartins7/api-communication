INSERT INTO tab_communications (tx_id_communication, dt_created,
                       dt_updated, tx_message, tx_contact_type, tx_device_communication, tx_status,tx_date, tx_time)
VALUES ('b830a60d-555a-40f9-847e-57383ce4c955',  NOW(), null, 'hello word', 'EMAIL', 'teste@teste.com.br', 'SENT',NOW(), NOW()),
       ('b830a60d-555a-40f9-847e-57383ce4c977',  NOW(), null, 'hello word', 'EMAIL', 'teste@teste.com.br', 'CANCELLED',NOW(), NOW()),
       ('b830a60d-555a-40f9-847e-57383ce4c966',  NOW(), null, 'hello word', 'EMAIL', 'teste@teste.com.br', 'SEND',NOW(), NOW());