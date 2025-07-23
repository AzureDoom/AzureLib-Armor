v3.0.13

### Bug Fixes
- Fixed an issue where keyframes would cause a crash if their index went below 0. The index now defaults to 0 when empty.  
  *Credit to Collinvh for identifying and resolving the issue.*
- Fixed a problem where snapshots or queues being null would cause a crash. These are now safely skipped instead.  
  *Credit to Collinvh for the fix.*

### Enhancements
- **Partial Ticks Support:**
    - Added support for partial ticks in the `applyMolangQueries` method. The old version of `applyMolangQueries` has been made private and is marked for future removal to ensure streamlined functionality.

### New MoLang Queries
The following queries have been added:

- **`query.item_current_durability`**
    - Provides the current durability of an item as a fraction of its maximum durability.
- **`query.item_is_enchanted`**
    - Returns whether the item is enchanted.