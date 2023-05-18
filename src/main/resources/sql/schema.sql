create table category
(
    id         varchar(36) NOT NULL DEFAULT (UUID()),
    name       varchar(64) NOT NULL,
    image_url  varchar(1024),
    created_on timestamp            DEFAULT CURRENT_TIMESTAMP,
    created_by varchar(64) NOT NULL,
    suspended  boolean              DEFAULT FALSE,
    deleted    boolean              DEFAULT FALSE,
    deleted_by varchar(64),
    deleted_on timestamp,
    PRIMARY KEY (id)
);

create table uom
(
    id         varchar(36) NOT NULL DEFAULT (UUID()),
    name       varchar(32) NOT NULL,
    brand      varchar(32),
    created_on timestamp            DEFAULT CURRENT_TIMESTAMP,
    created_by varchar(64) NOT NULL,
    suspended  boolean              DEFAULT FALSE,
    deleted    boolean              DEFAULT FALSE,
    deleted_by varchar(64),
    deleted_on timestamp,
    PRIMARY KEY (id)
);

create table product_template
(
    id          varchar(36) NOT NULL DEFAULT (UUID()),
    name        varchar(64) NOT NULL,
    description varchar(512),
    brand       varchar(64),
    image_url   varchar(512),
    category_id varchar(36) NOT NULL,
    created_on  timestamp            DEFAULT CURRENT_TIMESTAMP,
    created_by  varchar(64) NOT NULL,
    suspended   boolean              DEFAULT FALSE,
    deleted     boolean              DEFAULT FALSE,
    deleted_by  varchar(64),
    deleted_on  timestamp,
    INDEX brand_idx(brand),
    INDEX name_idx(name),
    PRIMARY KEY (id)
);

create table product_variant
(
    id         varchar(36) NOT NULL DEFAULT (UUID()),
    name       varchar(64) NOT NULL,
    created_on timestamp            DEFAULT CURRENT_TIMESTAMP,
    created_by varchar(64) NOT NULL,
    suspended  boolean              DEFAULT FALSE,
    deleted    boolean              DEFAULT FALSE,
    deleted_by varchar(64),
    deleted_on timestamp,
    UNIQUE KEY idx_name (name),
    PRIMARY KEY (id)
);

create table product_variant_option
(
    id         varchar(36) NOT NULL DEFAULT (UUID()),
    name       varchar(64) NOT NULL,
    created_on timestamp            DEFAULT CURRENT_TIMESTAMP,
    created_by varchar(64) NOT NULL,
    suspended  boolean              DEFAULT FALSE,
    deleted    boolean              DEFAULT FALSE,
    deleted_by varchar(64),
    deleted_on timestamp,
    UNIQUE KEY idx_name (name),
    PRIMARY KEY (id)
);


create table product
(
    id                  varchar(36)    NOT NULL DEFAULT (UUID()),
    sku_code            varchar(64)    NOT NULL,
    product_template_id varchar(36)    NOT NULL,
    created_by          varchar(64) NOT NULL,
    uom_id              varchar(36)    NOT NULL,
    price               decimal(13, 2) NOT NULL,
    discount            decimal                 default 0,
    image_url           varchar(512),
    extra_description   varchar(512),
    new                 boolean        NOT NULL default FALSE,
    sale                boolean        NOT NULL default FALSE,
    quantity            int            NOT NULL default 0,
    suspended           boolean                 DEFAULT FALSE,
    deleted             boolean                 DEFAULT FALSE,
    deleted_by          varchar(64),
    deleted_on          timestamp,
    FOREIGN KEY (uom_id) REFERENCES uom (id),
    FOREIGN KEY (product_template_id) REFERENCES product_template (id),
    INDEX idx_sku_code (sku_code),
    PRIMARY KEY (id)
);

create table product_variant_option_combination
(
    product_id                varchar(36) NOT NULL,
    product_variant_id        varchar(36) NOT NULL,
    product_variant_option_id varchar(36) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (product_variant_id) REFERENCES product_variant (id),
    FOREIGN KEY (product_variant_option_id) REFERENCES product_variant_option (id),
    UNIQUE KEY idx_id_variant_option (product_id, product_variant_id, product_variant_option_id)
);