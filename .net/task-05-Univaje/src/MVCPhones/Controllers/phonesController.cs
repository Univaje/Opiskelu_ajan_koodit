using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using MVCPhones.Data;
using MVCPhones.Models;

namespace MVCPhones.Controllers
{
    /*
     
    3. Add view (/phones/add) that contains fields for all Phone class' properties except the fields that are populated by 
    the app (the fields are marked with code comments on the class declaration). Use `Phone` class as the model type. 
    Model the fields so that POSTing the form will add a new phone information to the database. The view must not contain 
    any other fields for data input. Use `button` element as the submit button. When the POST is successful the app redirects 
    to /phones view to list all the phones including the newly added phone.

    4. Edit view (/phones/edit/[id]) that allows editing of the phone's data. Value for the [id] part of the url selects the 
    phone to be edited by it's Id property. Edit view renders input fields for all of the `Phone` class' properties and marks 
    input fields for properties `Id`, `Created` and `Modified` to readonly so user gets the indication that these fields should 
    not be modified by the user. The view must not contain any other fields for data input. Use `Phone` class as the model type. 
    Use `button` element as the submit button. POSTing the form makes the changes to the selected phone object and persists them to the database.
    When the POST is successful the app redirects to /phones view to list all the phones including the changed phone.

    5. Delete view (/phones/delete/[id]) that shows all of the selected phone's details and a button (submit type) where user can click to confirm delete.
    POSTing the confirmation form deletes the selected phone from the database. When the POST is successful the app redirects to /phones view to list all 
    the remaining phones.
    */
    public class phonesController : Controller
    {
        private readonly PhonesContext _context;

        public phonesController (PhonesContext context)
        {
            _context = context;
        }

        public async Task<IActionResult> Index()
        {
            return _context.Phones != null ?
                        View(await _context.Phones.OrderBy(p => p.Make).ThenBy(p => p.Model).ToListAsync()) :
                        Problem("Entity set 'PhonesContext.Phones'  is null.");
        }
        public IActionResult add()
        {
            return View();
        }

    
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> add([Bind("Make,Model,RAM,PublishDate")] Phone phone)
        {
            if (ModelState.IsValid)
            {
                _context.Add(phone);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index)); // palauttaa 302 redirectin
            }
            return View(phone);
        }


        // GET: phonesController1/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Phones == null)
            {
                return NotFound();
            }

            var phone = await _context.Phones.FindAsync(id);
            if (phone == null)
            {
                return NotFound();
            }
            return View(phone);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, Phone phone)
        {
            if (id != phone.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    //_context.Update(todoItem);
                    var itemFromDb = await _context.Phones.FindAsync(id);
                    if (itemFromDb != null)
                    {
                        itemFromDb.Id = phone.Id;
                        itemFromDb.Make = phone.Make;
                        itemFromDb.Model = phone.Model;
                        itemFromDb.RAM = phone.RAM;
                        itemFromDb.Created = phone.Created;
                        itemFromDb.PublishDate = phone.PublishDate;
                        itemFromDb.Modified = phone.Modified;

                        
                        await _context.SaveChangesAsync();
                    }

                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!PhoneExists(phone.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(phone);
        }

        // GET: phonesController1/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Phones == null)
            {
                return NotFound();
            }

            var phone = await _context.Phones
                .FirstOrDefaultAsync(m => m.Id == id);
            if (phone == null)
            {
                return NotFound();
            }

            return View(phone);
        }

        // POST: phonesController1/Delete/5
      
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Phones == null)
            {
                return Problem("Entity set 'TodoContext.Todos'  is null.");
            }
            var phone = await _context.Phones.FindAsync(id);
            if (phone != null)
            {
                _context.Phones.Remove(phone);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool PhoneExists(int id)
        {
            return (_context.Phones?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }

}
