# SupCooking
JEE Cooking App

## Code syntax conventions
### General JAVA

Everything must use either **lower-case-camel-case** or **upper-case-camel-case**. Classic.

### Database utilities
DAOs methods name shall respect the following syntax convention, based on the **CRUD** methods name.

- Create: `createModel()`
- Read...
  - all: `getAllModels()`
  - count: `getAllModelsCount()`
  - find: `findModelsByDiscriminator()`
- Update: `updateModel()`
- Delete: `deleteModel()`

## Database syntax conventions
Database entities shall use an **underscore-separated** and be **lower-cased** name.

For instance: `table_name`
