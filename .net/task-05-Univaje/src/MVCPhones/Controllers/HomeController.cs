using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MVCPhones.Models;
using MVCPhones.Data;
using Microsoft.EntityFrameworkCore;

namespace MVCPhones.Controllers;

public class HomeController : Controller
{

    private readonly PhonesContext _context;

    public HomeController(PhonesContext context)
    {
        _context = context;
    }

    public async Task<IActionResult> Index()
    {
        return _context.Phones != null ?
                    View(await _context.Phones.OrderByDescending(p => p.Modified).Take(4).ToListAsync()) :
                    Problem("Entity set 'phneContext.Categories'  is null.");
    }

    public IActionResult Privacy()
    {
        return View();
    }

    public async Task<IActionResult> Edit(int? id)
    {
        if (id == null || _context.Phones == null)
        {
            return NotFound();
        }

        var category = await _context.Phones.FindAsync(id);
        if (category == null)
        {
            return NotFound();
        }
        return View(category);
    }

    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Edit(int id, [Bind("MAke,Model")] Phone phone)
    {
        if (id != phone.Id)
        {
            return NotFound();
        }

        if (ModelState.IsValid)
        {
            try
            {
                _context.Update(phone);
                await _context.SaveChangesAsync();
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

    // POST: Categories/Delete/5
    [HttpPost, ActionName("Delete")]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> DeleteConfirmed(int id)
    {
        if (_context.Phones == null)
        {
            return Problem("Entity set 'PhoneContext.Categories'  is null.");
        }
        var category = await _context.Phones.FindAsync(id);
        if (category != null)
        {
            _context.Phones.Remove(category);
        }

        await _context.SaveChangesAsync();
        return RedirectToAction(nameof(Index));
    }


    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
    private bool PhoneExists(int id)
    {
        return (_context.Phones?.Any(e => e.Id == id)).GetValueOrDefault();
    }
}
